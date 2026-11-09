package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
    static class queue{
        Deque<Integer> q = new LinkedList<>();
        public void add(int data){
            q.addLast(data);
            
        }
        public int remove(){
            return  q.removeFirst();
        }
        public int peek(){
            return q.removeFirst();
        }
    }
    public static void main(String[] args) {
        // Deque<Integer> deq =new LinkedList<>();
        // deq.addFirst(1);
        // deq.addFirst(2);
        // deq.addLast(3);
        // System.out.println(deq);
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println("peek  = "+s.peek());
        // System.out.println("pop : "+ s.pop());
        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek ="+q.peek());
        System.out.println("remove : "+q.remove());
        System.out.println("remove : "+q.remove());
        System.out.println("remove : "+q.remove());
    }
    
}
