package Recursion;
// check if an array is sorted or not 
public class sortedArray {
    public static boolean checksorting(int array[],int idx){
        //base class
        if(idx == array.length -1){
          return true;

        }
        if(array[idx]<array[idx+1]){
            return checksorting(array, idx+1);

        }else{
             return false;
        }

       
    }
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5};
        System.out.println(checksorting(array, 0));
    }
    
}
