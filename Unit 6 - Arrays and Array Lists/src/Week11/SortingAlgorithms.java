package Week11;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {30, 20, 5, 70, 90, 85, 10};

        selectionSort(arr);
        insertionSort(arr);
    }
    //the selection sort will run , and sort through slowly even if the sequence is already sorted

    private static void insertionSort(int[] arr) {
        for(int i=0; i<arr.length; i++){
            int temp = arr[i];
            int j;
            for (j = i; j>0 && temp<arr[j-1]; j--) { //stop shifting when there is a smaller element before the one 
            //u r holding. Or you have reached the end and u can't shift anymore
                arr[j] = arr[j-1];
            }

            arr[j] = temp;
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i=0; i < arr.length-1; i++) { //division between the sorted and unsorted side
            int smallestIndex = i;
            for(int j=i+1; j<arr.length; j++){ //select (look for) the smallest on the unsorted side
                if(arr[j]<arr[smallestIndex]){
                    smallestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;            
        }
    }
}
