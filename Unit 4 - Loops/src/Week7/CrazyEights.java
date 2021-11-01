package Week7;

import java.util.Scanner;

public class CrazyEights {

    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";

    private static final String ACE = "A";
    private static final String KING = "K";
    private static final String QUEEN = "Q";
    private static final String JACK = "J";
    private static final String TEN = "T";

    private static final int MAX_CARDS = 5;

    public static void main(String[] args) {
      System.out.println("Welcome to Crazy Eights!");
      Scanner in = new Scanner(System.in);
      boolean playNow = true;
      while(playNow){
         playNow = play(in);
      }
    }
/**
 * 
 * @param in - Scanner
 * @return - if the player wants ton play again as a boolean value
 */
    private static boolean playAgain(Scanner in) {
      boolean validInput = false;

      while (!validInput) {
         System.out.println("Do you want to play again ([Y]es / [N]o)");
         String answer = in.nextLine().toUpperCase();
         if (answer.equals("YES") || answer.equals("Y")){
            return true;
         }else if (answer.equals("NO") || answer.equals("N")) {
            return false;
         }else {
            System.out.println("Invalid Input: Yes or No only!");
         }
      }

      return false;
   }
   /**
    * Plays a game
    * @param in - scanner
    * @return - if player would like to play again as a boolean value
    */

    private static boolean play(Scanner in) {
      int pPoints = 0;
      int c1Points = 0;
      int c2Points = 0;

      String pHand = "";
      String c1Hand = "";
      String c2Hand = "";

      boolean gameOver = false;
      boolean roundDone = false;

      String round = "";

      System.out.println();

      String firstCard = getCard();
      while(firstCard.substring(0,1).equals("8")){
          firstCard = getCard();
      }

      while(!gameOver){
         roundDone = false;
         String deal = deal(pHand, c1Hand, c2Hand);
         pHand = deal.substring(0, deal.indexOf("-"));
         c1Hand = deal.substring(deal.indexOf("-")+1, deal.indexOf("*"));
         c2Hand = deal.substring(deal.indexOf("*")+1);
         while(!roundDone){
          round = round(pHand, c1Hand, c2Hand, firstCard, in);
          pHand = round.substring(0, round.indexOf("-"));
          c1Hand = round.substring(round.indexOf("-")+1, round.indexOf("*"));
          c2Hand = round.substring(round.indexOf("*")+1, round.indexOf("_"));
          firstCard = round.substring(round.indexOf("_")+1);
          roundDone = roundOver(pHand, c1Hand, c2Hand);
          }
          pPoints = getPoints(pHand, pPoints);
          c1Points = getPoints(c1Hand, c1Points);
          c2Points = getPoints(c2Hand, c2Points);
          System.out.println("Player has "+pPoints+" points");
          System.out.println("Computer player 1 has "+c1Points+" points");
          System.out.println("Computer player 2 has "+c2Points+" points");
          gameOver = gameDone(pPoints, c1Points, c2Points);
       }
       winner(pPoints, c1Points, c2Points);
       boolean again = playAgain(in);
       if(again){
          return true;
       }else{
          return false;
       }
   }

   /**
    * deals cards to each player
    * @param pHand - player's hand
    * @param c1Hand - computer player 1's hand
    * @param c2Hand - computer player 2's hand
    * @return
    */
   private static String deal(String pHand, String c1Hand, String c2Hand) {
      pHand = "";
      c1Hand = "";
      c2Hand = "";
      for(int i = 0; i<MAX_CARDS; i++){
         pHand = getCard() + " " + pHand;
         c1Hand = getCard() + " " + c1Hand;
         c2Hand = getCard() + " " + c2Hand;
     }
     return pHand +"-"+ c1Hand +"*"+ c2Hand;
   }

   /**
    * deterines who the winner is
    * @param pPoints - player's points
    * @param c1Points - computer player 1's points
    * @param c2Points - computer player 2's points
    */

   private static void winner(int pPoints, int c1Points, int c2Points) {
      if(pPoints<c1Points && pPoints<c2Points){
         System.out.println("You won!!!!");
      }else if(c1Points<pPoints && c1Points<c2Points){
         System.out.println("Computer Player 1 won!!!!");
      }else if(c2Points<pPoints && c2Points<c1Points){
         System.out.println("Computer Player 2 won!!!!");
      }else if(pPoints==c1Points && pPoints<c2Points){
         System.out.println("Tie between Player and Computer Player 1!");
      }else if(c1Points==c2Points && c1Points<pPoints){
         System.out.println("Tie between Computer Player 1 and Computer Player 2!");
      }else if(pPoints==c2Points && pPoints<c1Points){
         System.out.println("Tie between Player and Computer Player 2!");
      }
   }

/**
 * determines if the game is over or not (whether at least one player has 100 points or more)
 * @param pPoints - player's points
 * @param c1Points - computer player 1's points
 * @param c2Points - computer player 2's points
 * @return - whether the game is over or not
 */
   private static boolean gameDone(int pPoints, int c1Points, int c2Points) {
       if(pPoints>=100 || c1Points>=100 || c2Points>=100){
         return true;
       }else{
          return false;
       }
   }
/**
 * Determines the number of total points a player has over all rounds they've played
 * @param hand - player's hand
 * @param points - total points from previous rounds (if this is the first round, this value equals zero)
 * @return - the total points
 */

   private static int getPoints(String hand, int points) {
      int totalPoints = 0;
      for(int i = 0; i<hand.length(); i+=3){
         if(hand.substring(i, i+1).equals("8")){
            totalPoints += 50;
         }else if(hand.substring(i, i+1).equals("A")){
            totalPoints += 1;
         }else if(hand.substring(i, i+1).equals("T")||hand.substring(i, i+1).equals("J")||hand.substring(i, i+1).equals("Q")||hand.substring(i, i+1).equals("K")){
            totalPoints += 10;
         }else if(Integer.parseInt(hand.substring(i, i+1))>1 && Integer.parseInt(hand.substring(i, i+1))<10){
            totalPoints += Integer.parseInt(hand.substring(i, i+1));
         }         
       }
       totalPoints += points;
      return totalPoints;
   }
/**
 * Determines if the round is over or not by checking if any player has cards left in their hand
 * @param pHand - player's hand
 * @param c1Hand - computer player 1's hand
 * @param c2Hand - computer player 2's hand
 * @return - whther the round is over or not as a boolean value
 */

   private static boolean roundOver(String pHand, String c1Hand, String c2Hand) {
       if(pHand.equals("")||c1Hand.equals("")||c2Hand.equals("")){
          System.out.println("-----------------------------------------------");
          return true;
       }else {
         System.out.println("-----------------------------------------------");
          return false;
       }
   }

   /**
    * Plays a round of the game where each player plays one card
    * @param pHand - player's hand
    * @param c1Hand - computer player 1's hand
    * @param c2Hand - computer player 2's hand
    * @param firstCard - face up card
    * @param in - scanner
    * @return - player's, computer 1's, computer 2's hands and the face up card all attached together and seperated with the characters "-", "*", and "_"
    */


   private static String round(String pHand, String c1Hand, String c2Hand, String firstCard, Scanner in) {
      System.out.println("Your Hand: "+ifTen(pHand));
      System.out.println("Computer Player 1's Hand: "+makex(c1Hand));
      System.out.println("Computer Player 2's Hand: "+makex(c2Hand));
      System.out.println();

      System.out.println("The face up card is: "+ifTen(firstCard));
      System.out.println();

      String beforePlayerFirstCard = firstCard;
       String p1breakdown = playerPlay(pHand, in, firstCard);
       pHand = p1breakdown.substring(0, p1breakdown.indexOf("-"));
       firstCard = p1breakdown.substring(p1breakdown.indexOf("-")+1);
      
       if(!beforePlayerFirstCard.equals(firstCard)){
       System.out.println("You play "+ifTen(firstCard));
       firstCard = playerEight(firstCard, in);
       
       }

       System.out.println("Your Hand: "+ifTen(pHand));
       System.out.println();
       
       String c1Breakdown = computerPlay(c1Hand, firstCard, 1);
       c1Hand = c1Breakdown.substring(0, c1Breakdown.indexOf("-"));
       firstCard = c1Breakdown.substring(c1Breakdown.indexOf("-")+1);

       System.out.println("Computer Player 1's Hand: "+makex(c1Hand));
       System.out.println();

       String c2Breakdown = computerPlay(c2Hand, firstCard, 2);
       c2Hand = c2Breakdown.substring(0, c2Breakdown.indexOf("-"));
       firstCard = c2Breakdown.substring(c2Breakdown.indexOf("-")+1);

       System.out.println("Computer Player 2's Hand: "+makex(c2Hand));
       System.out.println();

       return pHand +"-"+ c1Hand +"*"+ c2Hand +"_"+ firstCard;
   }

   /**
    * Replaces each card in computer player's hand to "XX " so player cannot see the hand
    * @param c1Hand - computer player's hand
    * @return - the hand written in X's Ex. "XX XX XX XX"
    */
   private static String makex(String c1Hand) {
      String xhand = "";
      for(int i = 0; i<c1Hand.length(); i+=3){
         xhand = "XX "+xhand;
      }
      return xhand;
   }
   /**
    * This method first checks if the card the player wants to play is an 8.
    * If the player plays an eight, this method asks it what suit they want to play.
    * if not, the player's card is just returned
    * @param card - the card the player wants to play
    * @param in - scanner
    * @return - An "8" with the suit that the player wants to play (represented as "H","C","S", or "D") attached to it
    */

   private static String playerEight(String card, Scanner in) {
      if(card.substring(0,1).equals("8")){
         boolean validInput = false;
         while (!validInput) {
         System.out.println("You have played an eight. Which suit would you like to choose ([H]earts / [S]pades / [D]iamonds / [C]lubs)?");
         String answer = in.nextLine().toUpperCase();
         if (answer.equals("HEARTS") || answer.equals("H")){
            return "8"+HEARTS;
         }else if (answer.equals("SPADES") || answer.equals("S")) {
            return "8"+SPADES;
         }else if (answer.equals("DIAMONDS") || answer.equals("D")) {
            return "8"+DIAMONDS;
         }else if (answer.equals("CLUBS") || answer.equals("C")) {
            return "8"+CLUBS;
         }else {
            System.out.println("Invalid Input. Please choose something else: ");
         }
      }
   }
      return card;
   }
   /**
    * If the computer can play, this method plays the card the computer can play
    * If the computer cannot, it draws another card for the computer and keeps drawing cards until the computer can play, or has picked up 5 cards
    * @param hand - computer's hand
    * @param firstCard - face up card
    * @param cNum - the computer player number (1 or 2)
    * @return - the computer's hand with the "-" character next to it and the the face up card all in one string
    */

   private static String computerPlay(String hand, String firstCard, int cNum) {
      String card  = computerMove(hand, firstCard);
      if(card.indexOf("-drawagain")>=0){
         card = card.substring(0,card.indexOf("-drawagain"));
         int c1numPickedUp = 0;
         boolean computerPlay = false;
         while(!computerPlay){
            if(c1numPickedUp<5){
               c1numPickedUp++;
               String compickup = getCard();
               System.out.println("Computer "+cNum+" cannot play with the cards it has. So it picks up: "+makex(compickup));
               hand += compickup + " ";
               card = computerMove(hand, firstCard);
               if(card.indexOf("-drawagain")>=0){
                  computerPlay=false;
                  card = card.substring(0,card.indexOf("-drawagain")); 
               }else{
                  computerPlay = true;
               }
            }else{
               System.out.println("Computer "+cNum+" cannot play. Next player goes.");
               return hand+"-"+firstCard;
            }
      }
      }
      firstCard = card;
      if(hand.indexOf(card)==0){
         hand = hand.substring(hand.indexOf(card)+card.length()+1);
      }else if(hand.indexOf(card)==hand.length()-card.length()-1){
         hand = hand.substring(0, hand.indexOf(card));
      }else{
         hand = hand.substring(0, hand.indexOf(card))+hand.substring(hand.indexOf(card)+card.length()+1);
      }
      if(firstCard.substring(0,1).equals("8")){
         String suit = getSuit();
         String printsuit = "";
         if(suit.equals("H")){
            printsuit = "hearts.";
         }else if(suit.equals("C")){
            printsuit = "clubs.";
         }else if(suit.equals("S")){
            printsuit = "spades.";
         }else {
            printsuit = "diamonds.";
         }
         System.out.println("Computer Player "+cNum+" has played an eight. The computer chooses "+printsuit);
         firstCard = "8"+suit;
      }
      System.out.println("Computer "+cNum+" plays: "+ifTen(firstCard));
      return hand+"-"+firstCard;
   }

   /**
    * 10 uses one more character than any other number from A to K. So in the code, "T" represents 10. 
    * This method checks if there is a 10 in the string entered and changes the 10 to a T so the string can be used in the code
    * This method is used when the player inputs the card they want to play. If they want to play a ten, it changes "10" to "T"
    * @param str - any string value entered in Ex. the player's hand, the face up card, etc.
    * @return - the string with all the "10"'s from the string replaced with T's
    */

   private static String reverseTen(String str) {
      String answer = "";
      if(str.indexOf("10")>=0){
         for(int i = 0; i<str.length(); i++){
            if(str.substring(i,i+1).equals("1")){
               answer = answer + "T";
            }else if(str.substring(i,i+1).equals("0")){
               
            }else{
               answer = answer + str.substring(i,i+1);
            }
         }
      }else{
         answer = str;
      }
      return answer;
   }

   /**
    * 10 uses one more character than any other number from A to K. So in the code, "T" represents 10. 
    * This method checks if there is a T in the string entered and changes the T to a 10 so the string can be printed
    * @param str - any string value entered in Ex. the player's hand, the face up card, etc.
    * @return - the string with all the "T"'s from the string replaced with 10's
    */

   private static String ifTen(String str) {
      String answer = "";
      if(str.indexOf("T")>=0){
         for(int i = 0; i<str.length(); i++){
            if(str.substring(i,i+1).equals("T")){
               answer = answer + "10";
            }else{
               answer = answer + str.substring(i,i+1);
            }
         }
      }else{
         answer = str;
      }
      return answer;
   }

   /**
    * This method plays the card the player selected on top of the face up card if they can play, If they cannot play, the computer picks up a card for them and adds it to their hand and checks if they can play now that they have a new card
    * @param pHand - the player's hand
    * @param in - scanner
    * @param firstCard - the current face up card
    * @return - the player's hand then the character "-" thent he face up card
    */

   private static String playerPlay(String pHand, Scanner in, String firstCard) {
      boolean play = false;
      int numPickedUp = 0;
      while(!play){
      if(canPlay(pHand, firstCard)){
          String playerCard = playerMove(in, pHand, firstCard);
          pHand = pHand.substring(0,pHand.indexOf(playerCard)) + pHand.substring(pHand.indexOf(playerCard)+3);
          firstCard = playerCard;
          play = true;
      }else{
          if(numPickedUp<5){
             String drawCard = getCard();
             System.out.println("You cannot play with the cards you have. You draw: "+ifTen(drawCard));
            pHand = pHand + drawCard + " ";
            numPickedUp++;
          }else{
             play = true;
             System.out.println("You cannot play. Play passes to computer player 1.");
          }
       }
      }
      return pHand+"-"+firstCard;
}

/**
 * Determines which card the computer plays, and if it can play
 * @param hand - the computer's hand
 * @param firstCard - the current face up card
 * @return - if the computer can play, the card it will play, if it cannot then the computer's hand with the phrase "-drawagain" attached to it
 */
   private static String computerMove(String hand, String firstCard) {
      boolean play = false;
      String answer = "";
      while(!play){
         for(int i = 0; i<hand.length()-1; i++){
            if(hand.substring(i+1, i+2).equals(firstCard.substring(firstCard.length()-1))&&!(hand.substring(i,i+1).equals("8"))){
               answer = hand.substring(i, i+2);
               play = true;
               i=hand.length();
            }
         }
         if(!play){
            for(int i = 0; i<hand.length(); i++){
               if(hand.substring(i, i+1).equals(firstCard.substring(0,1))&&!(hand.substring(i,i+1).equals("8"))){
                  answer = hand.substring(i, i+2);
                  play = true;
                  i=hand.length();;
               }
            }
         }
         if(!play){
            for(int i = 0; i<hand.length(); i++){
               if(hand.substring(i, i+1).equals("8")){
                  answer = hand.substring(i, i+2);
                  play = true;
                  i=hand.length();
               }
            }
         }
         if(!play){
            return hand+"-drawagain";
         }
      }
      return answer;

   }

   /**
    * This method determines whether the player can play or not
    * @param hand - player's hand
    * @param card - face up card
    * @return - if the player can play or not
    */

   private static boolean canPlay(String hand, String card) {
      for(int i = 0; i<hand.length(); i++){
         if(hand.substring(i, i+1).equals("8")){
            return true;
         }else if(hand.substring(i, i+1).equals(card.substring(0,1))){
            return true;
         }else if(hand.substring(i, i+1).equals(card.substring(1,2))){
            return true;
         }
      }
      return false;
    }

    /**
     * This method asks the user what card they would like to play from their deck, if they can play. 
     * @param in - scanner
     * @param hand - The player's current hand before selecting a card
     * @param firstCard - the current face up card
     * @return - the card the player selects to play
     */

    private static String playerMove(Scanner in, String hand, String firstCard) { 
      boolean play = false;
      String answer = "";
      while(!play){
      System.out.println("Your hand: "+ifTen(hand));
      System.out.print("Please enter a card to play: ");
      answer = in.nextLine().toUpperCase();
      answer = reverseTen(answer);
      if(answer.length()<2){
         System.out.println("Not a valid answer.");
      }else if(hand.indexOf(answer)<0){
         System.out.println("Not a valid answer.");
      }else{
         for(int i = 0; i<hand.length(); i++){
            if(answer.substring(0,1).equals("8")){
               play = true;
            }else if(hand.substring(i, i+1).equals(answer.substring(0,1))&&firstCard.substring(0,1).equals(answer.substring(0,1))){
               play = true;
            }else if(hand.substring(i, i+1).equals(answer.substring(answer.length()-1))&&firstCard.substring(answer.length()-1).equals(answer.substring(answer.length()-1))){
               play = true;
            }
         }
         if(!play){
         System.out.println("You cannot play that card. Please select another.");
         }
      }
      }
      
      return answer.substring(0,2);
    }

    /**
     * creates a card by calling the methods getSuit and getCard
     * @return - the card
     */

    private static String getCard() { 
        String card = getFace() + getSuit();
        return card;
     }

     /**
      * gets suit for a card
      * @return - the suit for the card
      */
  
     private static String getSuit() { 
        int suit = (int) (Math.random() * 4);
        if (suit == 0){
           return HEARTS;
        }else if (suit == 1){
           return SPADES;
        }else if (suit == 2){
           return CLUBS;
        }else{
           return DIAMONDS;
        }
     }

     /**
      * gets face for a card
      * @return - returns the face
      */
  
     private static String getFace() { 
        int face = (int) (Math.random() * 13) + 1;
        if (face > 1 && face < 10)
           return "" + face;
        else if(face == 10){
           return TEN;
        }else if (face == 1){
           return ACE;
        }else if (face == 11){
           return JACK;
        }else if (face == 12){
           return QUEEN;
        }else{
           return KING;
        }
     }
}
