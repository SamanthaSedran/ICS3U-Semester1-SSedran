package Week9;

public class Rectangle {
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    private double length;
    private double width;

    public Rectangle(double l, double w){
        length = l;
        width = w;
    }

    public Rectangle(double side){
        length = side;
        width = side;
    }

    public double getArea(){
        return length*width;
    }

    public double getPerimeter(){
        return 2*length+2*width;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Rectangle){
            Rectangle r = ((Rectangle)obj);
            return this.length == r.length && this.width == r.width;
        }
        return false;
    }

    public String toString(){
        return "Rectangle with length of "+length+" and width of "+width;
    }
}

