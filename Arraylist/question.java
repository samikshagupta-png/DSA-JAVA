package Arraylist;

import java.util.ArrayList;

public class question {
    public static  boolean monotonic(ArrayList<Integer> arrlist){
        int n = arrlist.size();
        boolean increasing = true;
        boolean decreasing = true;
        if (arrlist.size() <= 1) return true;
        for(int i =1;i<n;i++){
           if(arrlist.get(i) < arrlist.get(i-1)){
                increasing=false;
            }
            if(arrlist.get(i) >arrlist.get(i-1)){
                decreasing=false;
            }   
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(3);
        System.out.println(monotonic(list1)); 
        
        
    }
    
}
