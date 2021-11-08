package Week9;

public class Beverage {
    private int numOunces;
    private static int numSold = 0;
    private int numOz=0;

    public Beverage(int numOz){
        numOunces = numOz;
        numSold = numOz;

    }

    public static void refill(int n){
        numSold = n;
        //numOunces = n;//this gives an error bc numOunces does not belong to the class, it belongs to the instance
    }
}
