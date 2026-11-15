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
        public static String decode(String s){
            Stack<Character> x = new Stack<>();
            for(int i =0; i<s.length();i++){
                char ch =s.charAt(i);
                if(ch!= ']'){
                    x.push(ch);
                }else{
                    StringBuilder str = new StringBuilder();
                    while(!x.isEmpty() && x.peek()!='['){
                        str.append(x.pop());
                    }
                    x.pop();
                    str.reverse();
                    // Extract repetition count
                    StringBuilder num = new StringBuilder();

                    while (!x.isEmpty() && Character.isDigit(x.peek())) {
                        num.append(x.pop());
                    }

                    num.reverse();
                    int count = Integer.parseInt(num.toString());
                        // Repeat string
                    StringBuilder repeated = new StringBuilder();

                    for (int j = 0; j < count; j++) {
                        repeated.append(str);
                    }

                    // Push decoded characters back
                    for (char c : repeated.toString().toCharArray()) {
                        x.push(c);
                    }
                
                }
            }
            // Construct final answer
            StringBuilder ans = new StringBuilder();

            while (!x.isEmpty()) {
                ans.append(x.pop());
            }

            return ans.reverse().toString();
    }
        public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('a');
        ll.add('b');
        ll.add('c');
        ll.add('b');
        ll.add('a');
        // System.out.println(palindrome(ll));
        System.out.println(decode("2[cv]"));
        System.out.println(decode("3[b2[v]]L"));

    }
    
}
