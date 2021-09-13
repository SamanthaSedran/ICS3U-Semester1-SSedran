package Week1;

/**
 * final modifier - used to make a variable constant
 */
public class ExampleSix {
    public static void main(String[] args) {
        final int x = 7;
        //x = 8; - Syntax Error, because we cannot reassign a value to a final variable

        final int y;
        y = x; //no issue because this is the first time we are assigning a value to y

        final int NUMBER_OF_STUDENTS = 30;
        // constants names are written all in caps, it's a naming convention, and _ for spaces
        //Normally constants are written at the top
    }
}
