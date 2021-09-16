package Week2;

public class ModulusExample {
    public static void main(String[] args) {
        int num = 4729;
        int num1 = num / 1000;
        int num4 = num % 10;
        int num2 = num % 1000 / 100;
        int num3 = num / 10 % 10;
        num3 = num % 100 / 10;

        System.out.println(num1 + num2 + num3 + num4);
    }
}
