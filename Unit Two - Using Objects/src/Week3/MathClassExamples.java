package Week3;

public class MathClassExamples {
    public static void main(String[] args) {
        double a = -7.8;

        //Math.abs() - absolute value - this is static because you used the math class without creating an object
        //this method was called through an object, and not a class
        System.out.println(Math.abs(a));

        //Square root
        System.out.println(Math.sqrt(10));
        
        //Exponents - base, exponent
        System.out.println(Math.pow(2, 4));

        

    }
}
