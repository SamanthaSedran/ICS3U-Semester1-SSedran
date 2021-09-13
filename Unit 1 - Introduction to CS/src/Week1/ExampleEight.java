package Week1;

/**
 * Type Casting (Primitives)
 */
public class ExampleEight {
    public static void main(String[] args) {
        final int NUM_MARKS = 5;

        int markOne = 84, markTwo = 78, markThree = 87, markFour = 97, markFive = 63;

        double average = (double)(markOne + markTwo + markThree + markFour + markFive) / NUM_MARKS;
        //This (double) above makes the (markOne+markTwo...) into a decimal. This is called casting
        /*We can also make NUM_MARKS a double, for the purpose of the calculation, but it goes back to 
        integer on other lines*/

        System.out.println("The average is: " + average);

        //int y = 7.3; //type mismatch

        //int y = (double)3; //same error as above

        double z = 4.5;
        int y = (int) z; //I can turn a double into an int for the int variable y

        //narrow conversion   double -> int
        //widen conversion   int -> int

    }
}
