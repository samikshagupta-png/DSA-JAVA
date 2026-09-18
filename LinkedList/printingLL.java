package LinkedList;
// print a linsked list


public class printingLL {
    public   Node head;
    public   Node tail;
    public  static  class  Node {
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next= null;
        }
    
        
    }

    //addfirst
    public  void addFirst(int data){
        Node newNode = new Node(data);
        //step1 = create new node
       if(head == null){
        head = tail = newNode;
        return ;
       }

        //step 2 - newnode next = head
        newNode.next = head; // link 
        // step 3 -head  = newnode
        head = newNode;



    }
    public  void AddLast(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return ;
            }
            tail.next = newNode;
            tail = newNode;

    }
    public void print(){
        if(head == null){
            System.out.println("lL is empty");

        }
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        printingLL ll = new printingLL();
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(9);
        ll.AddLast(4);
        ll.AddLast(6);
        ll.print();
        
    }
    
}
