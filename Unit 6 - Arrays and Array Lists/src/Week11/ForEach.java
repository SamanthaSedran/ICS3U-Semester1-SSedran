package Week11;

public class ForEach {
    public static void main(String[] args) {
        int[] arr = {30, 20, 5, 70, 90, 85, 10};
        //for each - when u want to iterate through the array and we do not need the index
        //if u need the index use the for loop
        //cannot change the size of the arraylist (add or remove elements)

        int sum = 0;

        for(int el: arr){
            //right of colon xxx: here - what your iterating through
            //left of colon here:xxx - variable to represent the next element
            sum += el;
        }

        String[] words = {"Test", "Alphabet", "Steve", "baseball", "Leafs"};
        
        String vowels = "aeiouAEIOU";
        int numVowels = 0;
        for(String w: words){
            System.out.println(w);
            for(int i=0; i<w.length(); i++){
                String letter = w.substring(i, i+1);
                if(vowels.indexOf(letter)>=0){
                    numVowels++;
                }
            }
        }
        System.out.println(numVowels);

    }
}
