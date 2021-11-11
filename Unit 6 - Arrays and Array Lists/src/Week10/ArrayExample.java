package Week10;

public class ArrayExample{
    public static void main(String[] args) {
        iterateAnArray();
        accessArray();
        
    }

    private static void iterateAnArray() {
        int[] arr = {5, 3, 2, 5, 2};

        int sum = 0;

        for (int i=0; i<arr.length; i++){
            sum += arr[i];
        }
    }

    private static void accessArray() {
        int[] arr = new int[5];
        Animal[] animals = new Animal[3];

        // access the individual elements using the [index]
        arr[0] = 3;
        arr[1] = 7;
        arr[2] = 10;
        arr[3] = 12;
        arr[4] = -2;

        animals[0] = new Animal();
        animals[1] = new Animal();
        animals[2] = new Animal();
        
        System.out.println(arr.length);
        System.out.println(animals.length);
    }

}