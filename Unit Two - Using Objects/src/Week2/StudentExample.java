package Week2;

public class StudentExample {
    public static void main(String[] args) {
        Student shohei;

        shohei = new Student("Shohei", "123456", 11); //student# is in "" because it should be a string
        //shohei is a student (object variable)

        Student samantha = new Student("Samantha", "654321", 11);
        /*int x = 7, primitive variables store the value
        variable shohei stores shohei's attributes. It stores: name-Shohei, number-123456, grade-11
        primitives (int, double, etc.) store the actual value, object types(variables) store
        a reference to the actual object (strings are not primitives)
        */

        Student alan = shohei; //this variable stores a reference to shohei's attributes, alan has the same reference as shohei

        alan.increaseGrade();
        //because alan and shohei reference the same Student Object, both of their grades increase, there is only one object, they both reference it

        samantha.displayName();
        samantha.displayStudentNumber(); /*there are from student.java program, this program calls these things 
        then comes back and continues with the program*/
        samantha.increaseGrade();

        samantha = null; //I have dissapeared now

        /*samantha.displayGrade();, this does not run now, because I am null, it will create a NullPointerException
        cannot call a method from a null reference*/
        //if you declare a variable ex. Student michael; and not assign attributes to it, will be null
        //.NullPointerException means you are trying to call something that is null (will be on AP exam!)

        alan = new Student("Alan", "555555", 11);

        alan.addTest(87);
        alan.displayAverage();
        alan.addTest(92);
        alan.displayAverage();
        alan.addTest(96);
        alan.displayAverage();
        alan.addTest(67);
        alan.displayAverage();

        //alan.numMarks = 7; don't have access to public ... more on github on

    }
}
