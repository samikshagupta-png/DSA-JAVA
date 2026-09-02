package Recursion;

public class placeTilesqns {
    public static int placetiles(int n , int m){
        if(n==m){
            return 2;

        }
        if(n  < m){
            return 1;
        }

        int vertplacements = placetiles(n-m, m);
        int horplacements = placetiles(n-1, m);
        return vertplacements+horplacements;
    }
    public static void main(String[] args) {
        int n =4,m=2;
        System.out.println(placetiles(n, m));
    }
    
}
