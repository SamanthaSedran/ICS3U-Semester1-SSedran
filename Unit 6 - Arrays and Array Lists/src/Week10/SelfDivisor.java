package Week10;

public class SelfDivisor {
    public static void main(String[] args) {
        isSelfDivisors(128);
    }

    public static boolean isSelfDivisors(int number){
        String strnum = Integer.toString(number);
        for(int i=0; i<strnum.length()-1; i++){
            int tryit = Integer.parseInt(strnum.substring(i, i+1));
            if(number%tryit!=0){
                return false;
            }
        }
        return true;
    }

}
