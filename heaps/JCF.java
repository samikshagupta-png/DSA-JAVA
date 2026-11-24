package heaps;
import java.util.Comparator;
import java.util.PriorityQueue;
public class JCF{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3);
        pq.add(9);
        pq.add(0);
        pq.add(7);
        pq.add(4);
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }

    }
} 
