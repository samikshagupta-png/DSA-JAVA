package Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Binary {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            this.left=null;
            this.right=null;
        }

    }
    static  class binarytree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] ==-1){
                return  null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right =buildTree(nodes);

            return newNode;
        }
        public static void preorder(Node root){
            if(root == null){
               
                return ;
                
            }
            System.out.print(root.data +" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void Traversals(Node root){
            if(root== null){
                
                return ;
                
            }
            Traversals(root.left);
            System.out.print(root.data+" ");
            Traversals(root.right);

        }
        public static void postorder(Node root){
            if(root == null){
                return ;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data+" ");

        }
        public static  void levelorder(Node root){
            if(root == null){
                return ;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode== null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);

                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                    
                }
                
            }
        }
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return  Math.max(lh, rh)+1;

        }
        public static int count(Node root){
            if(root== null){
                return 0;
            }
            int ls = count(root.left);
            int rs= count(root.right);
            return  ls+rs+1;
        }
        public static int sum(Node root){
            if(root== null){
                return 0;
            }
             int leftsum = sum(root.left);
             int rightsum = sum(root.right);
             return  leftsum+rightsum+root.data;


        }
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int leftdia = diameter(root.left);
            int leftht = height(root.left);
            int rightdia = diameter(root.right);
            int rightht = height(root.right);
            int selfdai = leftht+rightht+1;
            return  Math.max(selfdai,Math.max(leftdia, rightdia));
        }
        public static  boolean isIdentical(Node node,Node subRoot){
            if(node == null && subRoot == null){
                return true;
            }else if(node == null || subRoot ==null || node.data!= subRoot.data){
                return false;
            }
            if(!isIdentical(node.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right, subRoot.right)){
                return  false;
            }
            return  true;
        } 
        public static boolean issubtree(Node root,Node subRoot){
            if(root== null){
                return false;
            }
            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }
            return  (issubtree(root.left, subRoot.left)||issubtree(root.right, subRoot.right));
        }
    }
    static class Info{
        Node node;
        int hd;
        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;

        }
    }
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap <Integer,Node> map = new HashMap<>();
        int min =0, max=0;
        q.add(new Info(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right!= null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max= Math.max(max,curr.hd+1);

                }
                
            }
            for(int i =min;i<=max;i++){
                    System.out.println(map.get(i).data+ " ");
            }
        }
        System.out.println();

    }
    public static  void Klevel(Node root, int level , int k){
        if(root == null){
            return ;
        }
        if(level == k){
            System.out.println(root.data+" ");
            return ;
        }
        Klevel(root.left,level+1,k);
        Klevel(root.right,level+1,k);
    }
    public static boolean getPath(Node root,int n , ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return  true;
        }
        boolean foundleft = getPath(root.left, n, path);
        boolean foundright  = getPath(root.right, n, path);
        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return  false;

    }
    public static  Node lca(Node root, int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        // Find path from root to n1
        getPath(root, n1, path1);

        // Find path from root to n2
        getPath(root, n2, path2);

        //last common ancestors 
        int i =0;
        for(i =0;i<path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static int lcadist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftdist = lcadist(root.left, n);
        int rightdist = lcadist(root.right, n);
        if(leftdist == -1 && rightdist ==-1){
            return -1;
        }else if(leftdist ==-1){
            return rightdist+1;
        }else{
            return leftdist+1;
        }

    }
    public static int mindist(Node root , int n1,int n2){
        Node lca = lca(root, n1, n2);
        int dist1 = lcadist(lca,n1);
        int dist2 = lcadist(lca,n2);
        return  dist1+dist2;
    }
        public static void main(String[] args) {
        // int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // Node root = binarytree.buildTree(nodes);
        // System.out.print(root.data);
        // binarytree.preorder(root);
        // binarytree.Traversals(root);
        // binarytree.postorder(root);
        // binarytree.levelorder(root);
        // int re=binarytree.height(root);
        // System.out.println(re);
        //  int x = binarytree.diameter(root);
        // System.out.println(x);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // int k =2;
        // Klevel(root,1,k);
        System.out.println(mindist(root,4, 6));
    }
    
    
}
