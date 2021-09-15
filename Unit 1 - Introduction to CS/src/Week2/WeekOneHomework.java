package Week2;

public class WeekOneHomework {
    public static void main(String[] args) {
        /* 1
        double num = 2.3;
        double numSquared = num*num;

        System.out.print("The number "+num+"'s square is "+numSquared);
        */

        /* 2
        int testAmount = 43;
        int studentAmount = 11;

        double percentGrade = (((double)studentAmount/testAmount) * 100)+0.5;

        System.out.print("The student got "+studentAmount+" out of "+testAmount+", so their grade is "+(int)percentGrade+"%.");
        */

        /* 3
        int x = 93758;
        int twoDigit = (x%10000-x%1000)/1000;
        int fourDigit = (x%100-x%10)/10;

        int product = twoDigit*fourDigit;
        System.out.print("When the number is "+x+", the product of the 2nd digit, "+twoDigit+", and 4th digit, "+fourDigit+", is "+product);
        */

        /*4
        int fVelocity;
        int iVelocity = 50;
        int acceleration = 40;
        int time = 60;

        fVelocity = iVelocity + acceleration*time;

        System.out.print("The final velocity of a car with an initial velocity of "+iVelocity+"km/h, and an acceleration of "+acceleration+"km/h over "+time+" minutes, is "+fVelocity+"km/h.");
        */

        /* 5
        int radius = 4;
        double area;

        area = Math.PI*(radius*radius);

        System.out.print("A circle with a radius of "+radius+" has an area of "+area);
        */

        /* 6
        int radius = 4;
        double volume;

        volume = (4*Math.PI/3)*radius*radius*radius;
        System.out.println("The volume of a sphere with a radius of " + radius + " is " + volume);
        */

        /*7
        int a = 2;
        int b = 3;
        int c = 4;
        int x = 5;
        int y;

        y = a*x*x + b*x + c;

        System.out.println("When a="+a+", b="+b+", c="+c+", and x="+x+", using the equation y=ax^2+bx+c, y="+y);
        */

        /*8
        int x1 = 2;
        int x2 = 3;
        int y1 = 4;
        int y2 = 5;
        int slope;

        slope = (y2-y1)/(x2-x1);

        System.out.println("When x1="+x1+", x2="+x2+", y1="+y1+", and y2="+y2+", the slope of the line is "+slope);
        */

        /*9
        int pennys = 2;
        int nickels = 3;
        int dimes = 4;
        int quarters = 5;
        int loonies = 6;
        int toonies = 7;
        double amount;

        amount = pennys*0.01+nickels*0.05+dimes*0.1+quarters*0.25+loonies+toonies*2;
        */

        /*10
        int a = 3;
        int b = 5;
        int c = 2;
        double x1;
        double x2;

        x1=(-b+Math.sqrt(b*b-4*a*c))/(2*a);
        x2=(-b-Math.sqrt(b*b-4*a*c))/(2*a);

        System.out.println("The two roots of the equation y="+a+"x^2+"+b+"x+"+c+" are "+x1+" and "+x2);
        */

    }
}
