package BST;

import java.util.ArrayList;

public class BST {
    static  class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static class Info{
        boolean isBst;
        int size;
        int min;
        int max;
        public Info(boolean isBst,int size,int min,int max){
            this.isBst = isBst;
            this.size = size;
            this.min=min;
            this.max=max;

        }

    }
    public static  int maxBST =0;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size+rightInfo.size+1;
        int min =Math.min(root.data,Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data,Math.max(leftInfo.max, rightInfo.max));
        if(root.data <=leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBst && rightInfo.isBst){
            maxBST= Math.max(maxBST, size);
             return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static  void getInorder(Node root ,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    public static Node createBST(ArrayList<Integer> arr,int st,int end){
        if(st > end){
            return null;
        }
        int mid =(st+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
        
    }
    public static Node mergeBSTs(Node root1,Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        //merge
        int i =0,j=0;
        ArrayList<Integer> finalarr =  new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalarr.add(arr1.get(i));
                i++;
            }else{
                finalarr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalarr.add(arr1.get(i));
            i++;
        }
        while(i<arr2.size()){
            finalarr.add(arr1.get(j));
            j++;
        }
         return createBST(finalarr, 0, finalarr.size()-1);
    }
   public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);

        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right.left = new Node(45);
        root.right.right = new Node(70);

        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        
    }
}
