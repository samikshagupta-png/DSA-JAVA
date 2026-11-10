package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public static void reverse(Queue<Integer> q){
        Queue<Integer> mq = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int n =q.size()/2;
        for(int i =0;i<n;i++){
            s.push(q.remove());
        }
        for(int i =0;i<n;i++){
            mq.add(s.pop());
        }
         while (!q.isEmpty()) {
            mq.add(q.remove());
        }

        while (!mq.isEmpty()) {
            System.out.print(mq.remove() + " ");
        }

    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
         q.add(20);
          q.add(30);
         q.add(40);
          q.add(50);
           q.add(60);
         q.add(70);
          q.add(80);
           q.add(90);
            q.add(100);
        reverse(q);
    }

    
}
