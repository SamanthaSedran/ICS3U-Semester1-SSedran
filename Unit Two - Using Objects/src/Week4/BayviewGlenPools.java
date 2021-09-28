package Week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        int length = 20;
        int width = 8;
        int shallowLength = 5;
        int transition = 7;
        int shallowHeight = 3;
        int deepHeight = 8;

        int linerCost = 2;

        int volume = calculateVolume(length, width, shallowLength, shallowHeight, transition, deepHeight);
        int area = calculateArea(length, width, shallowLength, shallowHeight, transition, deepHeight);

        double linerPrice = (double)area*linerCost;

        System.out.print("The amount of water required to keep the pool at 90% full is "+volume*0.9+" metres squared. The amount of liner needed is "+area+" metres squared, and the liner costs $"+linerPrice+".");

        
    }

    private static int calculateArea(int length, int width, int shallowLength, int shallowHeight, int transition,
            int deepHeight) {
                //Transition Triangle
                int heightTriangle = deepHeight-shallowHeight;
                double baseTriangle = Math.sqrt(transition*transition-heightTriangle*heightTriangle);
                int area = (int)(((baseTriangle*heightTriangle)/2+transition*width)+0.5);

                //Transition Square
                area += shallowHeight*(int)baseTriangle*2;

                //Deep End
                int deepLength = length-shallowLength-(int)baseTriangle;
                area += deepLength*width+deepHeight*width+deepLength*deepHeight*2;

                //Shallow End
                area += shallowLength*width+shallowHeight*width+shallowLength*shallowHeight*2;
                return area;
    }

    private static int calculateVolume(int length, int width, int shallowLength, int shallowHeight, int transition,
            int deepHeight) {
                //Transition Triangle
                int heightTriangle = deepHeight-shallowHeight;
                double baseTriangle = Math.sqrt(transition*transition-heightTriangle*heightTriangle);
                int volume = ((int)baseTriangle*heightTriangle)/2*width;

                //Transition Square
                volume += shallowHeight*width*(int)baseTriangle;

                //Deep End
                int deepLength = length-shallowLength-(int)baseTriangle;
                volume += deepHeight*deepLength*width;

                //Shallow End
                volume += shallowLength*width*shallowHeight;
                return volume;
    }
}
