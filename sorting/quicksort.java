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
    // search in sorted rotated sort array
    public static int search(int arr[],int tar, int si, int ei){
        if(si>ei){
            return -1;
        }
        int mid = si+(ei-si)/2;
        if(arr[mid]==tar){
            return mid;
        }
        //mid on l1
        if(arr[si] <=arr[mid]){
            if(arr[si] <= tar && tar <= arr[mid]){
                return search(arr, tar, si, mid-1);
            }else{
                return search(arr, tar, mid+1, ei);
            }
        }
        else{
            if (arr[mid] <= tar && tar <=arr[ei]){
                return search(arr, tar, mid+1, ei);

            }else{
                return search(arr, tar, si, mid-1);
            }
        }
    }



    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 0, 1,8};
        // quicksorting(arr, 0,arr.length-1);
        // printArr(arr);
        int target = 0;
        int tarIdx = search(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);

    }
}

