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
        public static String checkpath(String s) {

            Stack<String> st = new Stack<>();

            String arr[] = s.split("/");

            for (int i = 0; i < arr.length; i++) {

                if (arr[i].equals("") || arr[i].equals(".")) {
                    continue;
                }

                else if (arr[i].equals("..")) {
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                }

                else {
                    st.push(arr[i]);
                }
            }

            String ans = "";

            for (String str : st) {
                ans += "/" + str;
            }

            return ans.isEmpty() ? "/" : ans;
        }
        public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('a');
        ll.add('b');
        ll.add('c');
        ll.add('b');
        ll.add('a');
        // System.out.println(palindrome(ll));

    }
    
}
