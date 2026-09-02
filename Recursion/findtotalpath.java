package Recursion;

public class findtotalpath {
    public static int findpath(int n,int m,int i,int j ){
        if(i == m-1 && j == n-1){
            return 1;

        }
         if (i >= m || j >= n) {
            return 0;
        }
        int downpaths = findpath(n, m, i+1,j);
        int rightpaths = findpath(n, m, i,j+1);
        return downpaths+rightpaths;



    }
    public static void main(String[] args) {
        int n =3,m =3;
        int totalpath =findpath(n, m, 0, 0);
        System.out.println(totalpath);
    }
}
