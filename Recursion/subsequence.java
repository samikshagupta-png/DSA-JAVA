package Recursion;

import java.util.HashSet;
//unique subsequence
public class subsequence {
    public static void stringsubsequence(String str , int idx,String newString, HashSet<String>set ){
        if(idx == str.length()){
            if(set.contains(newString)){
                return;
            }else{
                System.out.println(newString);
                set.add(newString);
                return;
                    
            }
        }
        
        char currChar = str.charAt(idx);
        // to be 
        stringsubsequence(str, idx+1,newString+currChar,set);
        // not to be 
        stringsubsequence(str, idx+1, newString,set);
    }
    public static void main(String[] args) {
        String str ="abc";
        HashSet<String> set = new HashSet<>();
        stringsubsequence(str, 0, "",set);
        
    }
    
}
