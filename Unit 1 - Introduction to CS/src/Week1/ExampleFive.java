package Week1;
/**
 * More of the same.
 * Assignment/Variables and Primitives
 */

public class ExampleFive {
    public static void main(String[] args) {
        int x=80, y, z;  //declared 3 variables all on the same line (initialized x to be 80)
        y = 75;
        z = 87;

        double average = (x + y + z) / 3.0; /*integer math: if both operands are intergers (x, y, z are all 
        integers and so is the other operand, 3) the answer will be an interger, so we have to make one not an
        interger (3.0) to get the decimal (correct) value*/

        System.out.println(average);
    }
}
