package LinkedList;
// print a linsked list


public class printingLL {
    public   Node head;
    public   Node tail;
    public int size;
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
        size++;


    }
    public  void AddLast(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                size++;
                return ;
            }
            tail.next = newNode;
            tail = newNode;
            size++;

    }
    public void add(int idx,int data){
        if(idx ==0){
            addFirst(data);
            return ;
        }
        Node newNode = new Node(data);
        
        Node  temp = head;
        int i =0;
        while (i<idx-1) {
            temp = temp.next;
            i++;
            
        }
        newNode.next = temp.next;
        temp.next= newNode;
        size ++ ;
    }
    public void print(){
        if(head == null){
            System.out.println("lL is empty");

            return ;
        }
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public  int removeFirst(){
        if(size == 0){
            System.out.print("ll is empty");
            return  Integer.MIN_VALUE;
        }else if(size ==1){
            int val = head.data;
            head = tail = null;
            return  val;

        }
        int val = head.data;
        head=head.next;
        return val;
    }

     public  int removeLast(){
        if(size == 0){
            System.out.print("ll is empty");
            return  Integer.MIN_VALUE;
        }else if(size ==1){
            int val = head.data;
            head = tail = null;
            size =0;
            return  val;

        }
        // prev  : 1 = size-2
        Node prev = head;
        for(int i =0;i<size-2;i++){
            prev =prev.next;
        }
        int val = prev.next.data;//tail data
        prev.next = null;
        tail = prev;
        return val;
    }
    // search iterative
    public int itrsearch(int key){
        Node temp = head;
        int i =0;
        while(temp !=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int helper (Node head,int key){
        if(head ==null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx ==-1){
            return -1;
        }
        return idx +1;

    }
    public int recsearch(int key){
        return helper(head, key);
    }
    public static void main(String[] args) {
        printingLL ll = new printingLL();
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(9);
        ll.AddLast(4);
        ll.AddLast(6);
        ll.add(2,0);
        ll.print();
        ll.removeFirst( );
        ll.print();
        ll.removeLast();
        ll.print();
        System.out.println(ll.itrsearch(3));
        System.out.println(ll.size);
        
    }
    
}
