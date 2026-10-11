package LinkedList;

import java.util.LinkedList;

public class ZigZagLL {
    public static   Node head;
    public static   Node tail;
    class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
    }

    
    public void zigzag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast=fast.next.next;
        }
        Node mid = slow;
        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;   
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL,nextR;  

        while(left!=null && right !=null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;

        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(5);
        ll.addFirst(8);
        ll.addFirst(0);
        ll.addLast(3);
    }
    
}
