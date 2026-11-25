package heaps;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class JCF{
    static  class heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x = arr.size()-1;
            int par = (x-1)/2;
            while( x>0 && arr.get(x)<arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIndx = i;
            if(left<arr.size() && arr.get(minIndx)> arr.get(left)){
                minIndx=left;
            }
            if(right<arr.size() && arr.get(minIndx)> arr.get(right)){
                minIndx=right;
            }
            if(minIndx != i){
                int temp =arr.get(i);
                arr.set(i, arr.get(minIndx));
                arr.set(minIndx, temp);
                heapify(minIndx);
            }
        }
        public int remove(){
            int data = arr.get(0);
            //step 1 - swap first & last 
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step2 - delete last 
            arr.remove(arr.size()-1);
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size() ==0;
        }
        
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(3);
        // pq.add(9);
        // pq.add(0);
        // pq.add(7);
        // pq.add(4);
        // while(!pq.isEmpty()){
        //     System.out.print(pq.peek()+" ");
        //     pq.remove();
        // }
        heap h = new heap();
        h.add(0);
        h.add(9);
        h.add(4);
        while(!h.isEmpty()){
            System.out.print(h.peek()+" ");
            h.remove();
        }

    }
} 
