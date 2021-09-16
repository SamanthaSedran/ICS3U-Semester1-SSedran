package Week2;

/**
 * Compound Assignment Operators
 */
public class ExampleSeven {
    public static void main(String[] args) {
        int x = 1;

        //x = x + 7;  //x is assigned x+7 (add 7 to x and assign back to x)
        x += 7;   //8
        x -= 3;   //5
        x *= 2;   //10
        x /= 3;   //3
        x %= 4;   //3

        x++;
        ++x;
        x--;
        --x;
        //Right now, at this point, x == 3
        int y = 2 * x++; //if the ++ comes after, we will increment x after we've used it
        int z = 2 * ++x; //if the ++ comes before, we will increment x and then use it

        int a = 1;
        double t = 1.5;
        System.out.print(a+t);

    }
}
