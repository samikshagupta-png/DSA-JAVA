package Recursion;

public class Movexqns {
    public static void moveALLX(String str , int idx, int count , String newString){
        // base class
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }


        if(str.charAt(idx) == 'x'){
            count++;
            moveALLX(str, idx+1, count, newString);
        }
        else{
            newString += str.charAt(idx);
            moveALLX(str, idx+1, count, newString);

        }
    }
    public static void main(String[] args) {
         String str= "egwujbvxxxoihbnm";
         moveALLX(str, 0, 0, "");
    }
    
}
