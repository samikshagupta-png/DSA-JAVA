package Recursion;

public class pairingqns {
    public static int pair(int n){
        //base class
        if (n == 1 || n == 2) {
            return n;
        }

        //single
        int single = pair(n-1);
        int pairs =( n-1 *pair(n-2));
        int total = single + pairs;
        return total;

    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(pair(n));
        
    }
    
}
