package Arraylist;

import java.util.ArrayList;

public class containerqns {
    //by 2 pointer approach
    public static int waterstore(ArrayList<Integer> Height){
        int MaxWater =0;
        int lp=0;
        int rp =Height.size() -1;
        while(lp<rp){
            int ht = Math.min(Height.get(lp), Height.get(rp));
            int width = rp-lp;
            int currrwater = ht*width;
            MaxWater= Math.max(MaxWater, currrwater);
            if(Height.get(lp) <Height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return  MaxWater;


    }


    //by brute methode
    public static  int StoreWater(ArrayList<Integer> height){
        int maxWater = 0;
        for(int i =0; i<height.size();i++){
            for(int j =0;j<height.size();j++){
                int ht = Math.min(height.get(i),height.get(j));
                int width = j-i;
                int currWater = ht*width;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(StoreWater(height));
        System.out.println(waterstore(height));

    }
    
}
