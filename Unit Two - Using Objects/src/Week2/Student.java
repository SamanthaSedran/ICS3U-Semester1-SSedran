package Week2;


/**
 * A class is a blue print for a something that we can model, and create variables to use in our code.
 *
 */

public class Student { //most classes do not have mains
/**
 * Attributes that define a student
 * The state of a specific student is what is in hte attributes at a specific point. 
 * This code (class) defines what a student is 
 */
    private String name;
    private String studentNumber;
    private int grade;
    private int totalMarks;
    private int numMarks;
    private int average;
/**
 * The method with the same name as the class is used to instantiate(create) a student object (an object is an instance of a class)
 * constructor - same name as the class and its purpose is used to instantiate an instance of the class (create a state and places it in its... more on github)
 *
 * @param name
 * @param studentNumber
 * @param grade
 */
public Student(String name, String studentNumber, int grade) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.grade = grade;
    this.totalMarks = 0;
    this.numMarks = 0;
    this.average = 0;
  }


  /**
   * displayName, displayStudentNumber, increaseGrade, displayGrade
   * The methods (actions) in a class define behaviour for the class
   */

  public void displayName() {
    System.out.println(name);
  }
  /**
   * A void method performs a task and does not return a value
   */

  public void displayStudentNumber() {
    System.out.println(studentNumber);
  }
  /*
  non-static methods do not have the word (modifier static before the return type (void))
  ...more on github
  */
  public void increaseGrade() { //void methods perform a task, but do not return a value
    grade++;
  }

  public void displayGrade() {
    System.out.println(grade);
  }

  //naming conventions for variables and methods are the same (camelCase)
  public void displayAverage(){
    System.out.println(average);
  }

  public void addTest(int mark){
    totalMarks += mark;
    numMarks++;
    calculateAverage();
  }

  private void calculateAverage() {
    average = (double)totalMarks/numMarks;
  }

}