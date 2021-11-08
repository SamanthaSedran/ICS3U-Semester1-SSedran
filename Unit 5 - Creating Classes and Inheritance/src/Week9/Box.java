package Week9;

/*When we write "extends Rectangle" we are inheriting everything from Rectangle class*/
public class Box extends Rectangle {
    /*
    public Box(){
        If you do not write an explicit constructor then java supplies this one for you.
        It does nothing except call your parents no-argument constructor - super
        
       super is the parent class - in this case, Rectangle
        super();
    }*/

    private double height;
    public Box(double l, double w, double h){
        //length = l; // if a parent attribute or method is private, you don't get to access it directly
        //width = w;
        super(l,w); // if you are going to call your parent's constructor, it has to be the first thing in your constructor
        height = h;

        //super(l,w); // this placed here causes an error because it's not the first thing in the constructor
    }

    public Box(double side){
        super(side);
        height = side;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Box){
            Box b = ((Box)obj);
            return this.getLength() == b.getLength() && b.getWidth() == b.getWidth() && this.height == b.height;
        }
        return false;
    }

    public double getArea(){
        return 2*super.getArea() + getLength()*height*2 + getWidth()*height*2;
    }

    public double getVolume(){
        return super.getArea()*height;
    }

    public String toString(){
        return "Box with a length of "+getLength()+", width of "+getWidth()+", and a height of "+height;
    }

    public double getPerimeter(){
        return getLength()*2+getWidth()*2+height*4;
    }
}
