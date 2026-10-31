package Stack;

import java.util.Stack;

public class Maxarea {
    public static  void maxrecArea(int arr[]){
        int maxareas = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i =arr.length -1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;

            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        s = new Stack<>();
        for(int i =0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;

            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //current area
        for(int i =0; i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i]- nsl[i]-1;
            int currarea = height * width;
            maxareas = Math.max(currarea,maxareas);
        }
        System.out.println("max areas in histogram "+ maxareas);
    }
    public static void main(String[] args) {
        int arr[] ={2,4};
        maxrecArea(arr);
    }
    
}
