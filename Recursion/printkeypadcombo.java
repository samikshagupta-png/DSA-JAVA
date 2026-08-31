package Recursion;

public class printkeypadcombo {
    public  static String[] keypad = {
    "",     // 0
    "abc",  
    "def",  
    "ghi",  
    "jkl",  
    "mno",  
    "pqrs", 
    "tu",  
    "vwx",  
    "yz"
};
    public static void printcombo(String str , int idx,String combination){
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }
        char currchar = str.charAt(idx);
        String mapping = keypad[currchar -'0'];
        for(int i =0; i<mapping.length();i++){
            printcombo(str, idx+1, combination+ mapping.charAt(i));
        }

    }

    public static void main(String[] args) {
        String str = "23";
        printcombo(str, 0, "");
        
    }
    
}
