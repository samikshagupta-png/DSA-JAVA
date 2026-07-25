package sorting;

public class quicksort {
   public static void quicksorting(int arr[],int si,int ei){
        if (si >= ei){
            return ;
        }
        int pidX = partition(arr,si,ei);
        quicksorting(arr, si, pidX-1);
        quicksorting(arr,pidX+1, ei);
    } 
    public static int partition(int arr[], int si, int ei) {
    int pivot = arr[ei];   // Choose last element as pivot
    int i = si - 1;        // Index of smaller element

    for (int j = si; j < ei; j++) {
        if (arr[j] <= pivot) {
            i++;
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Place pivot in correct position
    i++;
    int temp = pivot;
    arr[ei] = arr[i];
    arr[i] = temp;

    return i;  // Return pivot index
}

    public static void printArr(int arr[]){
        for(int i =0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        quicksorting(arr, 0,arr.length-1);
        printArr(arr);
    }
}
