package LinkedList;
// print a linsked list


public class printingLL {
    public static   Node head;
    public static   Node tail;
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
        size--;
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
        size--;
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
    public void reverse(){
        Node prevs=null;
        Node curr =tail= head;
        Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prevs;
            prevs = curr;
            curr = next;
        }
        head = prevs;
    }
    public void deleteNthfromend(int n){
        //calculate size
        Node temp = head;
        int sz=0;
        while(temp!= null){
            temp = temp.next;
            sz++;
        }
        if(n ==sz){
            head=head.next;
        }
        //sz-n
        int i =1;
        int tofind = n-sz;
        Node prev = head;
        while(i<tofind){
            prev=prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return ;

    }
    public Node findMid(Node haed){
        Node slow =head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //slow is my midnode

    }
    public boolean checkpalindrome(){
        if(head == null || head.next==null){
            return true;

        }

        //step 1 :find mid
        Node midnode = findMid(head); 

        //step 2 : reverse 2nd half
        Node prev=null;
        Node curr = midnode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half head
        Node left = head;

        //step 3:chevk left half & right half
        while(right != null){
            if(left.data != right.data){
                return  false;
            }
            left = left.next;
            right= right.next;
        }
        return true;
    }
    public static  boolean iscycle(){
        Node  slow =head ;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            if(slow == fast){
                return  true;
            }
        }
        return false;
    }
    public static boolean removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }    
        }
        if(!cycle){
            return false ;
        }
        //find meeting point 
            slow = head;
            Node prev = null;
            while(slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            //remove cycle 
           if (prev != null) {
                prev.next = null;
            }
        
            return true;
        
    }
    public static void main(String[] args) {
        // printingLL ll = new printingLL();
        // ll.addFirst(1);
        // ll.addFirst(3);
        // ll.addFirst(9);
        // ll.AddLast(4);
        // ll.AddLast(6);
        // ll.add(2,0);
        // ll.print();
        // // ll.removeFirst( );
        // ll.print();
        // // ll.removeLast();
        // // ll.print();
        // System.out.println(ll.itrsearch(3));
        // System.out.println(ll.size);
        // ll.reverse();
        // ll.deleteNthfromend(0);
        // System.out.println(ll.checkpalindrome());
        // ll.print();

        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next =new Node(3);
        // head.next.next.next = head;
        // System.out.println(iscycle());


        head = new Node(1);
        Node temp = new Node(2);
        head.next=temp;
        head.next.next =new Node(3);
        head.next.next.next = temp;
        System.out.println(removeCycle());

    }
    
}
