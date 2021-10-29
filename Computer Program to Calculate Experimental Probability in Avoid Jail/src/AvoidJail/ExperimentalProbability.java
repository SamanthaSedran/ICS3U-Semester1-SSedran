package AvoidJail;

public class ExperimentalProbability {
    public static void main(String[] args) {
        int spun = 0;
        int die1 = 0;
        int die2 = 0;
        int trials = 50;
        int onedie = 0;
        int twodie = 0;
        int diffnum = 0;

        for(int i = 1; i<=trials; i++){
            spun = rollspin(spun);
            die1 = rollspin(spun);
            die2 = rollspin(spun);
            System.out.println(spun+" "+die1+" "+die2);
            if(spun==die1||spun==die2){
                onedie++;
            }else if(spun==die1&&spun==die2){
                twodie++;
            }else{
                diffnum++;
            }
        }
        System.out.println("Diffnum= "+diffnum+" Onenum= "+onedie+" Twonum= "+twodie);
    }

    private static int rollspin(int x) {
        x = (int)(Math.random()*6)+1;
        return x;
    }
}