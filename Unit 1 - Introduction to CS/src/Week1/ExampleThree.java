package Week1;
/**
 * Strings and Escape Sequences
 * @param args
 */
public class ExampleThree {
    public static void main(String[] args) {
        //System.out.println("This is very special!"); //compile error
        System.out.println("This is \"very\" special!"); // we use \ to escape special characters
        //System.out.println("This is \very special!"); //\v is not a esape sequence
        System.out.println("This\nis\nvery\nspecial!");
        System.out.println("This is \\very special!"); /* when you want to print a backslash in the middle of a sentence
        you have to put a backsplash before another backsplash*/
        
    }
}
