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
    private static final String WILD = "W";

    private static final int MAX_CARDS = 5;

    public static void main(String[] args) {
        int pPoints = 0;
        int c1Points = 0;
        int c2Points = 0;

        String pHand = "";
        String c1Hand = "";
        String c2Hand = "";

        System.out.println("Welcome to Crazy Eights!");

        for(int i = 0; i<MAX_CARDS; i++){
            pHand = getCard() + " " + pHand;
            c1Hand = getCard() + " " + c1Hand;
            c2Hand = getCard() + " " + c2Hand;
        }
        System.out.println("Your Hand: "+pHand);
        System.out.println("Computer Player 1's Hand: "+c1Hand);
        System.out.println("Computer Player 2's Hand: "+pHand);

        // playerHand => "7H AD KC"

        String firstCard = getCard();
        while(firstCard.substring(0,1).equals("8")){
            firstCard = getCard();
        }

        System.out.println("The 1st card drawn from the stock pile is: "+firstCard);

        Scanner in = new Scanner(System.in);

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
            pHand = pHand + getCard();
            numPickedUp++;
            }else{
               play = true;
            }
         }
         System.out.print("The top card of the deck is "+firstCard);
         } 
         String c1Card  = computerPlay(c1Hand, firstCard);
         if(c1Card.indexOf("-drawagain")>=0){
            c1Card = c1Card.substring(0,c1Card.indexOf("-drawagain"));
            int c1numPickedUp = 0;
            boolean computerPlay = false;
            while(!computerPlay){
               if(c1numPickedUp<5){
                  c1numPickedUp++;
                  c1Hand += getCard();
                  c1Card = computerPlay(c1Hand, firstCard);
                  if(c1Card.indexOf("-drawagain")>=0){
                     computerPlay=false;
                     c1Card = c1Card.substring(0,c1Card.indexOf("-drawagain")); 
                  }else{
                     computerPlay = true;
                  }
               }else{
                  c1Card = c1Card.substring(0,c1Card.indexOf("-drawagain"));
                  computerPlay = true;
               }
         }
         }
         if(c1Card.length()>4){
            c1Hand = c1Card;
            c1Card = firstCard;
            System.out.println("Computer 1 cannot play.");
         }else{
            firstCard = c1Card;
            System.out.println("Computer 1 plays: "+firstCard);
         }

         String c2Card  = computerPlay(c2Hand, firstCard);
         if(c2Card.indexOf("-drawagain")>=0){
            c2Card = c2Card.substring(0,c2Card.indexOf("-drawagain"));
            int c2numPickedUp = 0;
            boolean computerPlay = false;
            while(!computerPlay){
               if(c2numPickedUp<5){
                  c2numPickedUp++;
                  c2Hand += getCard();
                  c2Card = computerPlay(c2Hand, firstCard);
                  if(c2Card.indexOf("-drawagain")>=0){
                     computerPlay=false;
                     c2Card = c2Card.substring(0,c2Card.indexOf("-drawagain")); 
                  }else{
                     computerPlay = true;
                  }
               }else{
                  c2Card = c2Card.substring(0,c2Card.indexOf("-drawagain"));
                  computerPlay = true;
               }
         }
         }
         if(c2Card.length()>3){
            c2Hand = c2Card;
            c2Card = firstCard;
            System.out.println("Computer 2 cannot play");
         }else{
            firstCard = c2Card;
            System.out.println("Computer 2 plays: "+firstCard);
         }
         
    }

    private static String computerPlay(String hand, String firstCard) {
      boolean play = false;
      String answer = "";
      while(!play){
         for(int i = 0; i<hand.length(); i++){
            if(hand.substring(i, i+1).equals(firstCard.substring(firstCard.length()-1))&&!(hand.substring(i-1,i).equals("8"))){
               if(hand.substring(i-2,i).equals("10")){
                  answer=hand.substring(i-2, i+1);
               }else{
                  answer = hand.substring(i, i+1);
               }
               play = true;
               i=hand.length();
            }
         }
         if(!play){
            for(int i = 0; i<hand.length(); i++){
               if(hand.substring(i, i+1).equals(firstCard.substring(0,1))&&!(hand.substring(i+1,i+2).equals("8"))){
                  if(hand.substring(i, i+2).equals("10")){
                     answer=hand.substring(i, i+3);
                  }else{
                     answer = hand.substring(i, i+2);
                  }
                  play = true;
                  i=hand.length();;
               }
            }
         }
         if(!play){
            for(int i = 0; i<hand.length(); i++){
               if(hand.substring(i, i+1).equals("8")){
                  answer = WILD+getSuit();
                  play = true;
                  i=hand.length();;
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
         }else if(hand.substring(i, i+1).equals(card.substring(1,2))||((hand.substring(i,i+2).equals("10"))&&(hand.substring(i+2,i+3).equals(card.substring(2,3))))){
            return true;
         }
      }
      return false;
    }

    private static String playerMove(Scanner in, String hand, String firstCard) {
      boolean play = false;
      String answer = "";
      while(!play){
      System.out.print("Please enter a card to play: ");
      answer = in.nextLine().toUpperCase();
      if(hand.indexOf(answer)<0){
         System.out.println();
         System.out.println("Not a valid answer.");
      }else{
         for(int i = 0; i<hand.length(); i++){
            if(answer.substring(0,1).equals("8")){
               play = true;
            }else if(hand.substring(i, i+1).equals(answer.substring(0,1))&&firstCard.substring(0,1).equals(answer.substring(0,1))){
               play = true;
            }else if(hand.substring(i, i+1).equals(answer.substring(answer.length()-1))&&firstCard.substring(answer.length()-1).equals(answer.substring(answer.length()-1))){
               play = true;
            }//check if this works for tens
            
         }
         if(!play){
         System.out.println("You cannot play that card. Please select another.");
         }
      }
      }
      
      return answer;
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
