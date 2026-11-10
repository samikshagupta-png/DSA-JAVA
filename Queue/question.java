package queue;

import java.util.LinkedList;
import java.util.Queue;

public class question {
    public static void printbinary(int n){
        Queue<String> q = new LinkedList<>();
        //enque the first binary number
        q.add("1");
        // run n times to print binary number from 1 to n
        for(int i =1;i<=n;i++){
            // remove the first element and print it
            String s1 = q.remove();
            System.out.println(s1+" ");
            // generate the next two binary numbers by appending "0" & "1"
            String s2 = s1;
            q.add(s1+"0");
            q.add(s2+"1");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int n =7;
        printbinary(n);
    }

    
}
