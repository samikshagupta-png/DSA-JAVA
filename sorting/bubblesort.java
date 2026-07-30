package sorting;

public class bubblesort {
    public static void bubblessort(int arr[],int n){
        for(int i =0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if (arr[j]> arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void PrintArray(int arr[],int n){
        for(int i=0;i<n;i++){
            System.err.print(arr[i]+" ");
        };
    }
    public static void main(String[] args) {
        int n=5;
        int arr[] ={4,3,1,5,2};
        bubblessort(arr, n);
        PrintArray(arr,n);
    }
}
