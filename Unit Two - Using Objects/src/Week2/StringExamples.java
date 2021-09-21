package Week2;

public class StringExamples {
    public static void main(String[] args) {
        // Defined 3 references to String objects
        // When we use a String Literal we are NOT constructin an instance of an object
        String stringLiteral = "This is a String Literal";
        String anotherLiteral = "This is a String Literal";

        // The following 3 create 3 seperate instances of String Objects
        String somethingDifferent = new String("This is a String Literal"); //Mr. Deslaurier is lying (it's not)
        String somethingDifferent1 = new String("This is a String Literal");
        String somethingDifferent2 = new String("This is a String Literal1");

        //The Five Methods you Need to Know for the AP Exam
        //1
        System.out.println(stringLiteral.length()); //last index is one less than the length of the String
        //this method prints the length of the string

        //2 - the equals method
        System.out.println(stringLiteral.equals(somethingDifferent)); //if it's the same sequence of characters it's true, if it's not, it's false
        //the value above will either be true or false

        //3 - IndexOf
        System.out.println(stringLiteral.indexOf("in")); //i is the 13th character in the string (you need to start counting at 0, the T in this is the 0th character)

        //4 - Substring
        System.out.println(stringLiteral.substring(3)); //prints from the 3rd index of the string to the end
        System.out.println(stringLiteral.substring(3, 6)); //prints from the 3rd index of the string up to, but not including the 6th index
        
        String myName = "Samantha Sedran";
        String friendName = new String("Michael Gee");
        String repeatName = new String(myName);
        int ageSam = 16;
        int ageMic = 15;

        System.out.println(myName+" "+ageSam);
        friendName += ageMic;
        System.out.println(friendName);

        System.out.print("\""+myName+"\"");
        System.out.print("\n");
        System.out.print("\\"+friendName+"\\");
    }
}
