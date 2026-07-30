package sorting;
import java.util.Arrays;
//ApplyMergesorttosortanarrayofStrings.(Assumethatallthecharactersinall the Strings are in lowercase)
public class practiceqns {
    public static void sortarray(String[] arr,int si , int ei){
        if (si < ei) {
            int mid = si + (ei - si) / 2;
            sortarray(arr,si,mid);
            sortarray(arr,mid+1,ei);
            merge(arr,si,mid,ei);
        }
    }
    public static void merge(String[] arr,int si,int mid,int ei){
        // Sizes of two subarrays
        int n1 = mid - si +1;
        int n2= ei-mid;
        //temp arrays
        String[] L = new String[n1];
        String[] R = new String[n2];
        //copy data
        for(int i =0;i<n1;i++){
            L[i]=arr[si+i];
            

        };
        for(int j =0;j<n2;j++){
            R[j]=arr[mid+1+j];
        };

        // merge temp arrays back;
        int i =0,j=0,k=si;
        while(i<n1 && j<n2){
            if (L[i].compareTo(R[j])<=0){
                arr[k] =L[i];
                i++;
            }else{
                arr[k] =R[j];
                j++;
            }
            k++;
        };
        //copy remaining elements 
        while(i<n1){
            arr[k] = L[i];
            k++;i++;
            
        }
        while (j<n2){
            arr[k] = R[j];
            j++;
            k++;

        }
        // Driver code
        
    }
    public static void main(String[] args) {
            String[] arr = {"banana", "apple", "grape", "cherry", "mango"};
            System.out.println("Original: " + Arrays.toString(arr));

            sortarray(arr, 0, arr.length - 1);

            System.out.println("Sorted:   " + Arrays.toString(arr));
    } 
}
