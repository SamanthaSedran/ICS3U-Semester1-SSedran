package Week6;

public class CompareToExample {
    public static void main(String[] args) {
        System.out.print("abc".compareTo("bcde")); /*this compars two strings lexicographically alphabetically
        Whichever comes first in the alphabet is considered smaller
        For this: bcde > abc*/

        System.out.print("a".compareTo("g")); //prints -6 a < g
        System.out.print("g".compareTo("a")); //prints 6 g > a 
        System.out.print("g".compareTo("g")); //prints 0

        //prints 0 when strings are the same
        System.out.print("g".compareTo("G")); //prints 32

        //compares ASCII characters and prints ASCII value of the argument minus the ASCII value of the compare to - (this thing) "a".

        System.out.print("go".compareTo("get"));
        //go > get because o > e
        // compares 1st letters 1st, if they ae the same then second letters next ... etc.
        System.out.print("go".compareTo("goo")); //prints -1
    }
}
