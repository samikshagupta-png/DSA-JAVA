package Stack;

import java.util.ArrayList;

public class StackB {
    static class stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;

        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;

        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    static class Node{
        int data;
        Node next;
        Node(int data, Node next){
            this.data = data;
            this.next= next;
        }
    }
    static class Stacks{
        static Node head = null;
        public static boolean isEmpty(){
            return head == null;
        }
        //push
        public static void push(int data){
            Node newNode = new Node(data,null);
            if(isEmpty()){
                head=newNode;
            }
            newNode.next= head;
            head=newNode;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        // stack s= new stack();
        // Stack<Integer> s = new stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
    
}
