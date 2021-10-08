package Week5;

public class FactorialExample{
    public static void main(String[] args) {
        int n = 5;
        int result = factorial(n);
        System.out.print(result);
    }

    public static int factorial(int n){
        if (n==1){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }
    

    private static int fibonacci(int n) {
        //n is the nth number in the seqeunce

        if(n==1 || n==2){
            return 1;
        }else{
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }
}