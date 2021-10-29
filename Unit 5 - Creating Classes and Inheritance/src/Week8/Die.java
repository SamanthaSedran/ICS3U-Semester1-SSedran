package Week8;

public class Die{
    //private means it exists inside here and that's it, it cannot be accessed outside of the class
    //other classes cannot access private attributes/methods/constructors directly.
    private int topSide;

    private int numSides;

    /*
    Default/No-Argument constructor - 

    If you do not create a constructor for you that does nothing (stay tuned for Ch9)

    It happens at compilation (you will not see it, but it exists)
    */

    public Die(){
    //no return type because it has the same return type of the class, the class's return type is that it returns a die instance
    this.numSides = 6;
    roll();
    }

    //the word "this" refers to this particular instance of the die, the instance of the die that we are talking about 
    /**
     * If we have the following:
     * Die die1 = new Die();
     * die1.roll(); this(inside the class) would be die1
     * @param numSides
     */
    public Die(int numSides){
        this.numSides = numSides;
    }

    public void roll() {
        topSide = (int)(Math.random()*numSides)+1;
        //you could write what's above or this
        //this.topSide = (int)(Math.random()*this.numSides)+1;
    }

    public int getTopSide(){
        return topSide;
    }

    public String toString(){
        return ""+topSide;
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj instanceof Die){
            return this.topSide == ((Die) obj).topSide; //this checks to make sure it's a die, because if you tried to pass in something else, it wouldn't work
        }else{
            return false;
        }
    }

}