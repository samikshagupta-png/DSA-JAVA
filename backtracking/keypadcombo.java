package backtracking;
//Question 2 :Keypad CombinationsGivenastringcontainingdigitsfrom2-9inclusive,printallpossiblelettercombinationsthatthe number could represent. You can print the answer in any order.
// Amappingofdigitstoletters(justlikeonthetelephonebuttons)isgivenbelow.Notethat1does not map to any letters

public class keypadcombo {
    public  static String[] keypad = {
        "",
        "",     // 0
        "abc",  
        "def",  
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs", 
        "tuv",  
        "wxyz",  
        
    };
    public static void printkeypadcombo(String str,String combination,int idx){
         if(idx == str.length()){
            System.out.println(combination);
            return;
        }
        char currchar = str.charAt(idx);
        String mapping = keypad[currchar -'0'];
        for(int i =0; i<mapping.length();i++){
            printkeypadcombo(str, combination+ mapping.charAt(i),idx+1);
        }


    }
    public static void main(String[] args) {
        String str ="23";
        printkeypadcombo(str, "", 0);
        
    }
    
}
