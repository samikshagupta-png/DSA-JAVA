package BST;

import java.util.ArrayList;

public class build {
    static  class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data >val){
            root.left = insert(root.left, val);
        }
        else{
            root.right=insert(root.right, val);
        }
        return root;

    }
    public static  void inorder(Node root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
        

    }
    public static Node delete(Node root,int val){
        if(root.data <val){
            root.right = delete(root.right, val);
        }
        else if(root.data> val){
            root.left = delete(root.left, val);

        }
        else{
            //case 1 : - leaf node 
            if(root.left == null && root.right == null){
                return  null;
            }
            // case 2 : - single child
            if(root.left ==null){
                return root.right;

            }
            else if(root.right == null){
                return root.left;
            }
            //case 3 : - both children
            Node IS = findInordersuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, val);
        }
        return root;

    }
    public static Node findInordersuccesor( Node root){
        while(root.left!= null){
            root = root.left;
        }
        return root;

    }
    public static  void printInrange(Node root ,int k1,int k2){
        if(root == null){
            return ;
        }
        if(root.data>=k1 && root.data <= k2){
            printInrange(root.left ,k1,k2);
            System.out.print(root.data+" ");
            printInrange(root.right ,k1, k2);
        }
        else if(root.data <k1){
            printInrange(root.left ,k1,k2);
        }
        else{
            printInrange(root.right ,k1,k2);
        }

    }
    public static Node Mirror(Node root){
        if(root == null){
            return  null;
        }
        Node leftMirror = Mirror(root.left);
        Node rightMirror = Mirror(root.right);

        root.left= rightMirror;
        root.right = leftMirror;
        return root;

    }
    public static  void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    // public static Node CreateBST(int arr[],int st,int ei){
    //     if(st>ei){
    //         return null;
    //     }
    //     int mid = (st+ei)/2;
    //     Node root = new Node(arr[mid]);
    //     root.left=CreateBST(arr, st, mid-1);
    //     root.right=CreateBST(arr, mid+1, ei);
    //     return root;

    // }
    public static Node CreateBST(ArrayList<Integer> inorder,int st,int ei){
        if(st>ei){
            return null;
        }
        int mid = (st+ei)/2;
        Node root = new Node(inorder.get(mid));
        root.left=CreateBST(inorder, st, mid-1);
        root.right=CreateBST(inorder, mid+1, ei);
        return root;

    }
    public static  void getInorder(Node root,ArrayList<Integer> inorder){
        if(root == null){
            return ;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }
    public static  Node balanceBST(Node root){
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        root = CreateBST(inorder, 0, inorder.size()-1);
        return root;
    }
    public static void main(String[] args) {
        // int values[] = {8,5,3,1,4,6,10,11,14};
        // Node root = null;
        // for(int i =0;i<values.length;i++){
        //     root = insert(root,values[i]);

        // }
        // inorder(root);
        // System.out.println();
        // if(search(root, 1)){
        //     System.out.println("found");
        // }
        // // root = delete(root, 10);
        // System.out.println();
        // inorder(root);
        // printInrange(root, 5, 12);
        // int arr[]= {3,5,6,8,10,11,12};
        // root = balanceBST(root);
        // preorder(root);


    }
    
}
