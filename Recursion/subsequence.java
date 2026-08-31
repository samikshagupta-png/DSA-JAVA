package Recursion;

public class subsequence {
    public static void stringsubsequence(String str , int idx,String newString){
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }
        
        char currChar = str.charAt(idx);
        // to be 
        stringsubsequence(str, idx+1,newString+currChar);
        // not to be 
        stringsubsequence(str, idx+1, newString);
    }
    public static void main(String[] args) {
        String str ="abc";
        stringsubsequence(str, 0, "");
        
    }
    
}
