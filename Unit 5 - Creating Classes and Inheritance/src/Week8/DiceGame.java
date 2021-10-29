package Week8;

public class DiceGame {
     public static void main(String[] args) {
         Die die1 = new Die();
         Die die2 = new Die();
         //it already knows what a die is. if you are in the same passage you don't need to report

         int numPairs = 0;
         for(int i = 0; i<100; i++){
             die1.roll();
             die2.roll();
             System.out.println(die1+" "+die2);

             if(die1.equals(die2)){
                 numPairs++;
             }
             
         }
         System.out.println("Num Pairs: "+numPairs);
     }
}
