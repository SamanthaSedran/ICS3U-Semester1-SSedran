package Week11;

import java.util.ArrayList;

public class APVideos {
    public static void main(String[] args) {
        ArrayList<Boolean> a1 = new ArrayList<Boolean>();
        ArrayList<Turtle> a2 = new ArrayList<Turtle>();
        ArrayList<String> a3 = new ArrayList<String>(10);
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        display(a4, 5);
    }

    private static ArrayList<Integer> display(ArrayList<Integer> a4, int i) {
        ArrayList<Integer> temp = new ArrayList<Integer>(a4.size()*i);

        for(Integer j : temp){
            int n = i;
            while(i>0){
                temp.add(j);
            }
            
        }
        
        return temp;

    }
    
}
