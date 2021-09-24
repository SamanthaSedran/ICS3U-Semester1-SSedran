package Week3;

public class PracticeProblems {
    public static void main(String[] args) {
        questionA();
        questionB();
        questionC(20, 50);
        questionD();
        questionE("cherry");
        questionF("cherry", "er");
        questionG("cherry", "er");
        questionH(1, 2, 3, 4);
        questionI(1, 2);
        questionJ("cherry");
        question5();
    }

    public static void questionA(){
        int num = (int)(Math.random()*100)+1;
        System.out.println("Answer A: "+num);
    }

    public static void questionB(){
        int num = (int)(Math.random()*101)-50;
        System.out.println("Answer B: "+num);
    }

    public static void questionC(int min, int max){
        int num = (int)(Math.random()*max-min+1)+min;
        System.out.println("Answer C: "+num);
    }

    public static void questionD(){
        int num = (int)(Math.random()*6)+1;
        System.out.println("Answer D: "+num);
    }

    public static void questionE(String str){
        System.out.println("Answer E: "+str.substring(0, str.indexOf("e"))+str.substring(str.indexOf("e")+1));
    }

    public static void questionF(String str, String substr){
        String a = str.substring(0, str.indexOf(substr))+str.substring(str.indexOf(substr)+substr.length());
        System.out.println("Answer F: "+a);
    }

    public static void questionG(String str, String str2){
        int b = str.length()+str2.length();
        System.out.println("Answer G: "+b);
    }

    public static void questionH(int x1, int y1, int x2, int y2){
        double slope = (y2-y1)/(x2-x1);
        System.out.println("Answer H: "+slope);
    }

    public static void questionI(int r, int h){
        double volume = Math.PI*r*r*h;
        System.out.println("Answer I: "+volume);
    }

    public static void questionJ(String str){
        int num = (int)(Math.random()*str.length());
        String c = str.substring(0, num)+str.substring(num+1);
        System.out.println("Answer I: "+c);
    }

    public static void question5(){
        int totalGames = 110 + 44;
        double winningPercentage = (int)((110.0 / totalGames)*1000);
        System.out.println(winningPercentage);
    }
}
