package Recursion;
//Removeduplicate character in str code
public class Removeduplicate {
    public static boolean[] map = new boolean[26];
    public static void removeduplicate(String str, int idx,String newString){
        char currchar = str.charAt(idx);
        if(idx == str.length()-1){
            System.out.println(newString);
            return;
        }
        if(map[currchar -'a']  == true){
            removeduplicate(str,idx+1,newString);
        }else{
            newString += currchar;
            map[currchar -'a'] = true;
            removeduplicate(str, idx+1, newString);
        }
        
    }
    public static void main(String[] args) {
        String str = "abacjskfoeaaaamokd";
        removeduplicate(str, 0, "");
        
    }
    
}
