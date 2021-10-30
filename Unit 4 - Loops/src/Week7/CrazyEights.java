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
        int pPoints = 0;
        int c1Points = 0;
        int c2Points = 0;

        String pHand = "";
        String c1Hand = "";
        String c2Hand = "";

        System.out.println("Welcome to Crazy Eights!");
        System.out.println();

        for(int i = 0; i<MAX_CARDS; i++){
            pHand = getCard() + " " + pHand;
            c1Hand = getCard() + " " + c1Hand;
            c2Hand = getCard() + " " + c2Hand;
        }

        pHand = ifTen(pHand);
        System.out.println("Your Hand: "+pHand);
        pHand = reverseTen(pHand);
        c1Hand = ifTen(c1Hand);
        System.out.println("Computer Player 1's Hand: "+c1Hand);
        c1Hand = reverseTen(c1Hand);
        c2Hand = ifTen(c2Hand);
        System.out.println("Computer Player 2's Hand: "+c2Hand);
        c2Hand = reverseTen(c2Hand);
        System.out.println();

        String firstCard = getCard();
        while(firstCard.substring(0,1).equals("8")){
            firstCard = getCard();
        }

        firstCard = ifTen(firstCard);
        System.out.println("The 1st card drawn from the stock pile is: "+firstCard);
        firstCard = reverseTen(firstCard);
        System.out.println();

        Scanner in = new Scanner(System.in);

        String beforePlayerFirstCard = firstCard;
         String p1breakdown = playerPlay(pHand, in, firstCard);
         pHand = p1breakdown.substring(0, p1breakdown.indexOf("-"));
         firstCard = p1breakdown.substring(p1breakdown.indexOf("-")+1);
        
         if(!beforePlayerFirstCard.equals(firstCard)){
         firstCard = ifTen(firstCard);
         System.out.println("You play "+firstCard);
         firstCard = reverseTen(firstCard);
         firstCard = playerEight(firstCard, in);
         
         }

         pHand = ifTen(pHand);
         System.out.println("Your Hand: "+pHand);
         pHand = reverseTen(pHand);
         System.out.println();
         
         String c1Breakdown = computerPlay(c1Hand, firstCard, 1);
         c1Hand = c1Breakdown.substring(0, c1Breakdown.indexOf("-"));
         firstCard = c1Breakdown.substring(c1Breakdown.indexOf("-")+1);

         c1Hand = ifTen(c1Hand);
         System.out.println("Computer Player 1's Hand: "+c1Hand);
         c1Hand = reverseTen(c1Hand);
         System.out.println();

         String c2Breakdown = computerPlay(c2Hand, firstCard, 2);
         c2Hand = c2Breakdown.substring(0, c2Breakdown.indexOf("-"));
         firstCard = c2Breakdown.substring(c2Breakdown.indexOf("-")+1);

         c2Hand = ifTen(c2Hand);
         System.out.println("Computer Player 2's Hand: "+c2Hand);
         c2Hand = reverseTen(c2Hand);
         System.out.println();

         System.out.println("Round Over");
  
    }

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
               System.out.println("Computer cannot play with the cards it has. So it picks up: "+compickup);
               hand += compickup + " ";
               card = computerMove(hand, firstCard);
               if(card.indexOf("-drawagain")>=0){
                  computerPlay=false;
                  card = card.substring(0,card.indexOf("-drawagain")); 
               }else{
                  computerPlay = true;
               }
            }else{
               hand = card.substring(0,card.indexOf("-drawagain"));
               System.out.println("Computer "+cNum+" cannot play. Next player goes.");
               return hand+"-"+firstCard;
            }
      }
      }
      firstCard = card;
      if(hand.indexOf(card)==0){
         hand = hand.substring(hand.indexOf(card)+card.length()+1);
      }else{
         hand = hand.substring(0, hand.indexOf(card)-1)+hand.substring(hand.indexOf(card)+card.length());
      }
      System.out.println("Computer "+cNum+" plays: "+firstCard);
      return hand+"-"+firstCard;
   }

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
             System.out.println("You cannot play with the cards you have. You draw: "+drawCard);
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
                  answer = "8"+getSuit();
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

    private static String playerMove(Scanner in, String hand, String firstCard) {
      boolean play = false;
      String answer = "";
      while(!play){
      System.out.println("Your hand: "+hand);
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

    private static String getCard() {
        String card = getFace() + getSuit();
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

      /* if(card.substring(0,1).equals("A")){
         card = "1"+card.substring(1,2);
     }else if(card.substring(0,1).equals("J")){
         card = "11"+card.substring(1,2);
     }else if(card.substring(0,1).equals("Q")){
         card = "12"+card.substring(1,2);
     }else if(card.substring(0,1).equals("K")){
         card = "13"+card.substring(1,2);
     }else{
        card = "0"+card;
     }*/
}
