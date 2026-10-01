package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MergeSort{
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow; // mid value
    }
    private Node merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1!= null && head2!=null){
            if(head1.data<= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1!= null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
            
        }
        while(head2!= null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;

        }
        return mergedLL.next; 
    }
     public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
        public Node mergesort(Node head){
            if(head == null || head.next == null){
                return head;

            }

            //find mid
            Node mid = getMid(head);

            //left &right MS
            Node righthead = mid.next;
            mid.next = null;
            Node newleft =mergesort(head);
            Node newRight = mergesort(righthead);

            //merge
            return merge(newleft, newRight);
        }
        public static void main(String[] args) {
        MergeSort ms = new MergeSort();

        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original List:");
        ms.printList(head);

        head = ms.mergesort(head);
        
        System.out.println("Sorted List:");
        ms.printList(head);
    } 
    
}
