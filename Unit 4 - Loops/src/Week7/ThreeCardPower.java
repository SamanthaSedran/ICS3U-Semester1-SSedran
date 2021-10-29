package Week7;

import java.util.Scanner;

public class ThreeCardPower {

   private static final String HEARTS = "H";
   private static final String CLUBS = "C";
   private static final String DIAMONDS = "D";
   private static final String SPADES = "S";

   private static final String ACE = "A";
   private static final String KING = "K";
   private static final String QUEEN = "Q";
   private static final String JACK = "J";
   private static final int MAX_CARDS = 3;
   private static final int PLAYER_WINS = 1;
   private static final int DEALER_WINS = 2;
   private static final int TIE = 3;

   private static final int HIGH_CARD = 1;
   private static final int PAIR = 2;
   private static final int THREE_OF_A_KIND = 3;
   private static final int STRAIGHT = 4;
   private static final int FLUSH = 5;
   private static final int STRAIGHT_FLUSH = 6;

   private static boolean playAgain(Scanner in) {
      boolean validInput = false;

      while (!validInput) {
         System.out.println("Do you want to play again ([Y]es / [N]o)");
         String answer = in.nextLine().toUpperCase();
         if (answer.equals("YES") || answer.equals("Y"))
            return true;
         else if (answer.equals("NO") || answer.equals("N")) {
            return false;
         } else {
            System.out.println("Invalid Input: Yes or No only!");
         }
      }

      return false;
   }

   public static void main(String[] args) {
      // 7H -> 7 of Hearts
      // AD -> Ace of Diamonds
      // KC -> King of Clubs

      // playerHand => "7H AD KC"
      // dealerHand => "XX XX XX"
      final int MIN_BET = 50;
      final int MAX_BET = 100;
      Scanner in = new Scanner(System.in);
      int wallet = 500;
      boolean playAgain = true;
      while (playAgain) {
         wallet = playPokerHand(in, wallet, MIN_BET, MAX_BET);
         if (wallet >= MIN_BET * 2)
            playAgain = playAgain(in);
         else {
            System.out.println("You don't have enough money to play again!");
            playAgain = false;
         }
      }
   }

   private static int playPokerHand(Scanner in, int wallet, int minBet, int maxBet) {
      int bet = getBet(in, wallet, minBet, maxBet);

      String playerHand = "";
      String dealerHand = "";

      for (int i = 0; i < MAX_CARDS; i++) {
         playerHand += getCard(playerHand) + " ";
      }

      for (int i = 0; i < MAX_CARDS; i++) {
         dealerHand += getCard(playerHand + dealerHand) + " ";
      }

      System.out.println("Player: " + playerHand);
      System.out.println("Dealer: " + "XX XX XX");
      if (!fold(in)) {
         bet += getBet(in, wallet, minBet, maxBet);
         playerHand = discard(in, playerHand);
         System.out.println(playerHand);
      } else {
         System.out.println("Player folds.");
         wallet -= bet;
         return wallet;
      }

      if (compareHands(playerHand, dealerHand) == PLAYER_WINS) {
         System.out.println("Player Wins!");
         wallet += bet;
      } else if (compareHands(playerHand, dealerHand) == DEALER_WINS) {
         System.out.println("Dealer Wins!");
         wallet -= bet;
      } else {
         System.out.println("Tie");
      }

      return wallet;

   }

   private static int compareHands(String playerHand, String dealerHand) {
    if(getHand(playerHand) > getHand(dealerHand)){
        return PLAYER_WINS;
    }else if(getHand(playerHand) < getHand(dealerHand)){
        return DEALER_WINS;
    }else{
        if(getHighCard(playerHand) > getHighCard(dealerHand)){
            return PLAYER_WINS;
        }else if(getHighCard(playerHand) < getHighCard(dealerHand)){
            return DEALER_WINS;
        }else{
            return TIE;
        }
    }
}

private static int getHand(String cards) { 
    if(isFlush(cards) && isStraight(cards)){
        return STRAIGHT_FLUSH;
    }else if(isFlush(cards)){
        return FLUSH;
    }else if(isStraight(cards)){
        return STRAIGHT;
    }else if(isThreeOfAKind(cards)){
        return THREE_OF_A_KIND;
    }else if(isPair(cards)){
        return PAIR;
    }else{
        return HIGH_CARD;
    }
}

//playerHand => "7H AD KC"
// labels       "01_34_67"

private static boolean isPair(String cards) {
    if(cards.substring(0,1).equals(cards.substring(3,4))){
        return true;
    }else if(cards.substring(0,1).equals(cards.substring(6,7))){
        return true;
    }else if(cards.substring(3,4).equals(cards.substring(6,7))){
        return true;
    }else{
        return false;
    }
}

private static boolean isThreeOfAKind(String cards) {
    if(cards.substring(0,1).equals(cards.substring(3,4))&&cards.substring(6,7).equals(cards.substring(7,8))){
        return true;
    }else{
        return false;
    }
}

private static boolean isStraight(String cards) {
    String card1 = cards.substring(0,1);
    String card2 = cards.substring(3,4);
    String card3 = cards.substring(6,7);
    int a = Integer.parseInt(convertNum(card1));
    int b = Integer.parseInt(convertNum(card2));
    int c = Integer.parseInt(convertNum(card3));
    if(a==1 || b==1 || c==1){
        if((a==13 || b==13 || c==13)&&(a==12 || b==12 || c==12)){
            return true;
        }
    }
    if(a-1==b && a-2==c){
        return true;
    }else if(a-1==c && a-2==b){
        return true;
    }else if(b-1==a && b-2==c){
        return true;
    }else if(b-1==c && b-2==a){
        return true;
    }else if(c-1==a && c-2==b){
        return true;
    }else if(c-1==b && b-2==a){
        return true;
    }else{
        return false;
    }
}

private static String convertNum(String card) {
    if(card.equals("A")){
        card = "1";
    }else if(card.equals("J")){
        card = "11";
    }else if(card.equals("Q")){
        card = "12";
    }else if(card.equals("K")){
        card = "13";
    }
    return card;
}

private static boolean isFlush(String cards) {
    if(cards.substring(1,2).equals(cards.substring(4,5))&&cards.substring(1,2).equals(cards.substring(7,8))){
        return true;
    }else{
        return false;
    }
}

private static int getHighCard(String cards) {
    String card1 = cards.substring(0,1);
    String card2 = cards.substring(3,4);
    String card3 = cards.substring(6,7);
    int a = Integer.parseInt(convertNum(card1));
    int b = Integer.parseInt(convertNum(card2));
    int c = Integer.parseInt(convertNum(card3));
    if(a==1){
        a=14;
    }else if(b==1){
        b=14;
    }else if(c==1){
        c=14;
    }
    if(a>b && a>c){
        return a;
    }else if(b>a && b>c){
        return b;
    }else if(c>b && c>a){
        return c;
    }
    return 0;
}

   private static boolean fold(Scanner in) {
      boolean validInput = false;

      while (!validInput) {
         System.out.println("What would you like to do ([F]old / [D]iscard): ");
         String answer = in.nextLine().toUpperCase();
         if (answer.equals("FOLD") || answer.equals("F"))
            return true;
         else if (answer.equals("DISCARD") || answer.equals("D")) {
            return false;
         } else {
            System.out.println("Invalid Input: Discard or Fold only!");
         }
      }

      return false;
   }

   private static String discard(Scanner in, String playerHand) {

      int numCardsToReplace = getNumber(in, "How many cards would you like to discard: ", 0, 3);
      String temp = playerHand;
      if (numCardsToReplace == 0)
         return playerHand;
      else if (numCardsToReplace == 3) {
         playerHand = getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
      } else {
         String cardToReplace = getCardsToDiscard(in, numCardsToReplace, playerHand);
         int space = cardToReplace.indexOf(" ");
         String card1 = "";
         if (space == -1)
            card1 = cardToReplace;
         else
            card1 = cardToReplace.substring(0, space);

         String card = getCard(playerHand + temp);
         playerHand = playerHand.replace(card1, card);
         if (numCardsToReplace == 2) {
            String card2 = cardToReplace.substring(space + 1);
            card = getCard(playerHand + cardToReplace + temp);
            playerHand = playerHand.replace(card2, card);
         }
      }
      return playerHand;
   }

   private static String getCardsToDiscard(Scanner in, int numCardsToReplace, String playerHand) {
      final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
      boolean validInput = false;
      String cards = "";
      while (!validInput) {
         System.out.println("Please enter the cards to replace: (ex. 7H KD): ");
         cards = in.nextLine().toUpperCase();
         if (countOccurences(cards, " ") != numCardsToReplace - 1) {
            System.out.println("You must choose " + numCardsToReplace + " cards.");
         } else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) < 0))
            System.out.println("You don't have a " + cards);
         else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) >= 0))
            validInput = true;
         else if (numCardsToReplace == 2) {
            int space = cards.indexOf(" ");

            String card1 = cards.substring(0, space);
            String card2 = cards.substring(space + 1);
            if (VALID_CARDS.indexOf(card1) < 0)
               System.out.println("Not a valid card: " + card1);
            else if (VALID_CARDS.indexOf(card2) < 0)
               System.out.println("Not a valid card: " + card2);
            else if (playerHand.indexOf(card1) < 0)
               System.out.println("You don't have a " + card1);
            else if (playerHand.indexOf(card2) < 0)
               System.out.println("You don't have a " + card2);
            else if (playerHand.equals(card2))
               System.out.println("You cannot discard the same card.");
            else
               validInput = true;
         }

      }

      return cards;

   }

   private static int countOccurences(String str, String str2) {
      int count = 0;
      if (str2.length() > str.length())
         return 0;

      for (int i = 0; i < str.length(); i++) {
         String substr = str.substring(i, i + str2.length());
         if (str2.equals(substr))
            count++;
      }
      return count;

   }

   private static int getNumber(Scanner in, String prompt, int min, int max) {
      boolean validInput = false;
      int val = 0;
      while (!validInput) {
         System.out.print(prompt);
         try {
            val = Integer.parseInt(in.nextLine());

            if (val < min || val > max) {
               System.out.println("Invalid input!");
            } else {
               validInput = true;
            }
         } catch (Exception ex) {
            System.out.println("Invalid input!");
         }
      }
      return val;

   }

   private static String getCard(String cardsUsed) {
      String card = getFace() + getSuit();

      while (cardsUsed.indexOf(card) >= 0) {
         card = getFace() + getSuit();
      }

      return card;
   }

   private static String getSuit() {
      int suit = (int) (Math.random() * 4);
      if (suit == 0)
         return HEARTS;
      else if (suit == 1)
         return SPADES;
      else if (suit == 2)
         return CLUBS;
      else
         return DIAMONDS;
   }

   private static String getFace() {
      int face = (int) (Math.random() * 13) + 1;
      if (face > 1 && face < 11)
         return "" + face;
      else if (face == 1)
         return ACE;
      else if (face == 11)
         return JACK;
      else if (face == 12)
         return QUEEN;
      else
         return KING;
   }

   private static int getBet(Scanner in, int wallet, int minBet, int maxBet) {
      boolean validInput = false;

      int bet = 0;
      while (!validInput) {
         System.out.print("Please enter a wager [$" + minBet + " - $" + maxBet + "]: $");
         try {
            bet = Integer.parseInt(in.nextLine());

            if (bet > wallet)
               System.out.println("You do not have that much money in your wallet. $" + wallet + " is all you have.");
            else if (bet < minBet || bet > maxBet) {
               System.out.println("You must make a bet between $" + minBet + " - $" + maxBet);
            } else {
               validInput = true;
            }
         } catch (Exception ex) {
            System.out.println("Invalid Bet!");
         }
      }

      return bet;
   }
}