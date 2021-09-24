package Week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(twoChar("Happy", 1));
        System.out.println(removeChars("Happy", 1, 2));
        System.out.println(sqrtSum(3456));
    }

    /*Prints 3 copies of a substring (2 chars) in str starting at index
    Example: twoChar("Happy, 1") => "apapap"
    */
    public static String twoChar(String str, int index){
        String s = str.substring(index, index+2);
        return s+s+s;


    }
    //trying to remove n number of characters starting at index
    public static String removeChars(String str, int index, int n){
        String a = str.substring(0, index);
        String b = str.substring(n+index);
        return a+b;
    }

    public static double sqrtSum(int number){
        int n1 = number/1000; //2457/1000 = 2
        int n2 = number/100 %10; //2475/100 = 24%10 = 4
        int n3 = number/10 %10; //2457/10 = 245 %10 = 5
        int n4 = number/1 %10; //2457%10 = 4
        //Notice the pattern above?

        return (Math.sqrt(n1+n2+n3+n4));

    }

    
    
}
