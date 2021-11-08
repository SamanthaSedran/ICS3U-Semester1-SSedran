package Week9;

public class ShapeDriver {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5,3);
        Rectangle r2 = new Rectangle(7);

        System.out.print("Perimeter of r2: "+r2.getPerimeter());
        System.out.print("Area of r2: "+r2.getArea());

        if(r1.equals(r2)){
            System.out.print("The rectangles are equal.");
        }else{
            System.out.print("The rectangles are not equal.");
        }

        System.out.print(r1.toString());
        System.out.print(r2.toString());

        Box box1 = new Box(5,6,2);
        Box box2 = new Box(7);

        System.out.println(box2);
        System.out.println("Volume of box1: "+box1.getVolume());

        
    }
}
