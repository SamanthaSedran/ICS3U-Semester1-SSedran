package Week1;

public class DayTwoHomework {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int c = 2;
        double x1;
        double x2;

        x1=(-b+Math.sqrt(b*b-4*a*c))/(2*a);
        x2=(-b-Math.sqrt(b*b-4*a*c))/(2*a);

        System.out.println("The two roots of the equation y="+a+"x^2+"+b+"x+"+c+" are "+x1+" and "+x2);

}}

/** Q1 - Area of a Circle
 *      double pi = Math.PI;
        int radius = 4;
        double area;

        area = pi*radius*radius;
        System.out.println("The area of a circle with a radius of " + radius + " is " + area);

    Q2 - Volume of a Sphere
        int radius = 4;
        double volume;

        volume = (4*Math.PI/3)*radius*radius*radius;
        System.out.println("The volume of a sphere with a radius of " + radius + " is " + volume);

    Q3 - Solving the Equation: y = ax^2+bx+c
        int a = 2;
        int b = 3;
        int c = 4;
        int x = 5;
        int y;

        y = a*x*x + b*x + c;

        System.out.println("When a="+a+", b="+b+", c="+c+", and x="+x+", using the equation y=ax^2+bx+c, y="+y);

    Q4 - Slope of a Line
        int x1 = 2;
        int x2 = 3;
        int y1 = 4;
        int y2 = 5;
        int slope;

        slope = (y2-y1)/(x2-x1);

        System.out.println("When x1="+x1+", x2="+x2+", y1="+y1+", and y2="+y2+", the slope of the line is "+slope);
    
    Q5 - Calculate the Amount of Money the User Has
        int pennys = 2;
        int nickels = 3;
        int dimes = 4;
        int quarters = 5;
        int loonies = 6;
        int toonies = 7;
        double amount;

        amount = pennys*0.01+nickels*0.05+dimes*0.1+quarters*0.25+loonies+toonies*2;

        System.out.println("When the user has "+pennys+" penny(s), "+nickels+" nickel(s), "+dimes+" dime(s), "+quarters+" quarter(s), "+loonies+" loonie(s), and "+toonies+" toonie(s), the user has $"+amount);

    Q6 - Find the Roots of the Equation in Q3
        int a = 3;
        int b = 5;
        int c = 2;
        double x1;
        double x2;

        x1=(-b+Math.sqrt(b*b-4*a*c))/(2*a);
        x2=(-b-Math.sqrt(b*b-4*a*c))/(2*a);

        System.out.println("The two roots of the equation y="+a+"x^2+"+b+"x+"+c+" are "+x1+" and "+x2);

    Idea for isNaN Checker:
            if (x1.isNaN()==true) {
            System.out.println("The equation is cannot be factored.");
        } else{
            System.out.println("The two roots of the equation y="+a+"x^2+"+b+"x+"+c+" are "+x1+" and "+x2);
        }
 */
