package sorting;

public class MergeSort {
    public static void merge_sorting(int arr[], int si, int ei) {
        // Base case: stop when single element
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        // Recursively sort left and right halves
        merge_sorting(arr, si, mid);
        merge_sorting(arr, mid + 1, ei);

        // Merge the sorted halves
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;      // left index
        int j = mid + 1; // right index
        int k = 0;       // temp index

        // Merge both halves
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp back into original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        merge_sorting(arr, 0, arr.length - 1);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
