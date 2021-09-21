package Week3;

public class RandomExamples {
    public static void main(String[] args) {
        double r = Math.random();
        //for (int i=0; i<1000; i){
        System.out.println(r); // random number betweeen 0.0 and 1.0, not including 1.0 (ex. 0.514751872)
        //}
        //Getting a random number between 1 and 10 (including 1 and 10)
        System.out.println((int)(r*10)+1);

        //Random number between lower and upper bound
        int lower = -5;
        int upper = 5;

        int result = (int)((upper-lower+1)*r) + lower;
        System.out.println((int)((upper-lower+1)*r) + lower);

        String str = "Random numbers";

        //change a random character in the string to a x

        int index = (int)(Math.random()*str.length());

        str = str.substring(0, index) + "x" + str.substring(index+1);

        System.out.print(str);
    }
}
