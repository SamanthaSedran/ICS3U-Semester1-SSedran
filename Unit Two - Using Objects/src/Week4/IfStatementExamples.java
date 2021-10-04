package Week4;

public class IfStatementExamples {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo(98);
        exampleThree();
    }

    private static void exampleThree() {
        //OR -> || Ex. (x>7||y<7) //if x>7 or y<7 it is true

        //AND -> && Ex. (x>7&&y<7) //if x>7 and y<7 it is true

        //NOT -> ! Ex. !(x>7) //if x is not bigger than seven 7, it is true 

        /*
        >
        <
        >=
        <=
        ==(don't use with strings)
        != (not equals)
        */
    }

    private static void exampleTwo(int mark) {
        if(mark >= 90){
            System.out.println("A+");
        }else if(mark >= 80){
            System.out.print("A");
        }else if(mark >= 70){
            System.out.print("B");
        }else if(mark >= 60){
            System.out.print("C");
        }else if(mark >= 50){
            System.out.print("D");
        }else{
            System.out.print("F");
        }

        /*Prints B, C, D
        if(mark >= 90){
            System.out.println("A+");
        }if(mark >= 80){
            System.out.print("A");
        }if(mark >= 70){
            System.out.print("B");
        }if(mark >= 60){
            System.out.print("C");
        }if(mark >= 50){
            System.out.print("D");
        }else{
            System.out.print("F");
        }
        */
    }

    private static void exampleOne() {
        /*
        if (boolean expression is true){
            //do this
        }        
        */
    
        int x = 7;
        if(x%2==0){
            System.out.println(x+" is even!");
        }else{
            System.out.println(x+" is odd!");
        }


    }

    public String deFront(String str) {    
        if(str.length()<1){
          return str;
        }else if(str.length()==1 && !str.equals("a") && !str.equals("b")){
          return "";
        }else if(str.length()==1 && (str.equals("a") || str.equals("b"))){
          return str;
        }else if(str.length()==2 && !str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "";
        }else if(str.length()==2 && str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "a";
        }else if(str.length()==2 && !str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "a";
        }else if(str.length()==2 && !str.substring(0,1).equals("a") && str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "b";
        }else if(str.length()==2 && !str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && str.substring(1,2).equals("b")){
          return "b";
        }else if(str.length()==2 && str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "aa";
        }else if(str.length()==2 && !str.substring(0,1).equals("a") && str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && str.substring(1,2).equals("b")){
          return "bb";
        }else if(str.length()==2 && str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && str.substring(1,2).equals("b")){
          return "ab";
        }else if(str.length()==2 && !str.substring(0,1).equals("a") && str.substring(0,1).equals("b") && str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "ba";
        }else if(str.length()>2 && str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "a"+str.substring(2);
        }else if(str.length()>2 && !str.substring(0,1).equals("a") && str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "b"+str.substring(2);
        }else if(str.length()>2 && !str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "a"+str.substring(2);
        }else if(str.length()>2 && !str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && str.substring(1,2).equals("b")){
          return "b"+str.substring(2);
        }else if(str.length()>2 && str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "aa"+str.substring(2);
        }else if(str.length()>2 && !str.substring(0,1).equals("a") && str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && str.substring(1,2).equals("b")){
          return "bb"+str.substring(2);
        }else if(str.length()>2 && str.substring(0,1).equals("a") && !str.substring(0,1).equals("b") && !str.substring(1,2).equals("a") && str.substring(1,2).equals("b")){
          return "ab"+str.substring(2);
        }else if(str.length()>2 && !str.substring(0,1).equals("a") && str.substring(0,1).equals("b") && str.substring(1,2).equals("a") && !str.substring(1,2).equals("b")){
          return "ba"+str.substring(2);
        }else{
          return str.substring(2);
        }
      }
      
}
