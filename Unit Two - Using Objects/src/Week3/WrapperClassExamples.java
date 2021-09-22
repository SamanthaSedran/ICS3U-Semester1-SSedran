package Week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
       //Integer n = new Integer(7); 
       /*this is out of date, and VS code no longer lets you do this, 
       but you need to do this for the ap exam*/
       //Double d = new Double(3.2); - this is a reference to an integer object
       Integer num = 7; //this is a primitive int, not an object

       //auto-boxing - storing an integer in an object, were wrapping the value up and keeping a reference to it
       int m = num; /*this is auto-unboxing, where you store the reference to the object in a primitve variable, it 
       unboxes it for you and changes the reference to a stored value */

       int x = 6 + num; //auto-unboxing so we can add a primitive and object(wrapper) together
       int y = m + num; //you can add primitives and the wrapper classes together

       int z = num.intValue();
       //same as int z = num;
       Double d = 2.3;
       double f = d.doubleValue();

       System.out.println(Integer.MAX_VALUE); //Static constants that represent the largest and smallest possible ints
       System.out.println(Integer.MIN_VALUE);
    }
}
