package Stack;

import java.util.Stack;

public class validParanthesis {
    public static boolean isvalid(String str){
        Stack<Character> s = new Stack<>();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch == '(' || ch =='{' || ch == '['){
                s.push(ch);

            }else{
                if(s.isEmpty()){
                    return  false;
                }
                if((s.peek() == '(' && ch ==')' )||(s.peek() =='{' && ch =='}')||(s.peek()=='[' && ch == ']')){
                    s.pop();

                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean duplicatepara(String str){
        Stack<Character> s = new Stack<>();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch ==')'){
                int count =0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }if(count <1){
                    return  true;
                }else{
                    s.pop();
                }

            }else{
                s.push(ch);
            }
        }
        return false;

    }
    public static void main(String[] args) {
        String str = "({[]})";
        System.out.println(isvalid(str));
        System.out.println(duplicatepara(str));
    }

    
}
