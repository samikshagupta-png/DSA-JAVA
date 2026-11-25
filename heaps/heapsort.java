package heaps;

public class heapsort {
    public static  void heapify(int arr[], int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIndx = i;
        if(left<size &&  arr[left] > arr[maxIndx]){
            maxIndx=left;
        }
        if(right<size && arr[right] > arr[maxIndx]){
            maxIndx=right;
        }
        if(maxIndx !=i){
            //swap
            int temp = arr[i];
            arr[i] = arr[maxIndx];
            arr[maxIndx] = temp;
            heapify(arr, maxIndx, size);
        }
    }
    public static void heapsor(int arr[]){
        int n =arr.length;
        for(int i =n/2;i>=0;i--){
            heapify(arr, i, n);
        }

        for(int i =n-1;i>0;i--){
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        int arr[] ={1,2,4,5,3};
        heapsor(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
