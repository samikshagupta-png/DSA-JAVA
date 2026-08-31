package Recursion;

public class ReverseString {
   public static void reversestring(String word,int idx){
    
     // base classs
    if(idx== 0){
        System.out.println(word.charAt(idx));
        return;
    }
     //recusrion 
     System.out.println(word.charAt(idx));
     reversestring(word, idx -1);



   }
   public static void main(String[] args) {
    String word = "abcdjdkowe";
    reversestring(word, word.length()-1);
   }
}
