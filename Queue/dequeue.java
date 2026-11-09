package queue;

import java.util.Deque;
import java.util.LinkedList;

public class dequeue {
    static  class Stack{
        Deque<Integer> d = new LinkedList<>();
        public void push(int data){
            d.addLast(data);
        }
        public int pop(){
            return d.removeLast();
        }
        public int peek(){
            return d.getLast();
        }
    }
    public static void main(String[] args) {
        // Deque<Integer> deq =new LinkedList<>();
        // deq.addFirst(1);
        // deq.addFirst(2);
        // deq.addLast(3);
        // System.out.println(deq);
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek  = "+s.peek());
        System.out.println("pop : "+ s.pop());
    }
    
}
