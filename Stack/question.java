package Stack;

import java.util.LinkedList;
import java.util.Stack;

public class question {
    public static boolean palindrome(LinkedList<Character> ll){
        if( ll.isEmpty()){
            System.out.println("Linkedlist is empty ");
            return true;
        }
        Stack<Character> s = new Stack<>();
        for(int i =0;i<ll.size();i++){
            s.push(ll.get(i));
        }
        for(int i =0;i<ll.size();i++){
            if(ll.get(i) != s.pop()){
                return  false;
            }
        }
        return true;


    } 
    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('a');
        ll.add('b');
        ll.add('c');
        ll.add('b');
        ll.add('a');
        System.out.println(palindrome(ll));

    }
    
}
