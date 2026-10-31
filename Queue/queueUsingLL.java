package Queue;
class Node{
   int data;
   Node next;
   Node(int data){
    this.data= data;
    this.next = null;
   }


}

public class queueUsingLL {
    static class queue{
        static  Node head = null;
        static  Node tail = null;
        static  int rear ;
        static int front;
        public static boolean isEmpty(){
            return  rear == -1 && front == -1;

        }
        public static void add(int data){
            Node newNode = new Node(data);
            if( head == null){
                head = tail = newNode;
                return ;
                
            }
            tail.next = newNode;
            tail = newNode;
        }
        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return  -1;
            }
            int front = head.data;
            if(tail == head){
                tail = head= null;
            }
            else{
                head=head.next;
            }
            return  front;
        
        }


    }
    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }
    }
    
    
}
