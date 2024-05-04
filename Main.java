package Lab9;

public class Main {
    public static void main(String[] args){
        int[] arr = {0, 2, 4, 6, 8, 10, 12}; //worst for mergesort
        print(mergeSort(arr, 0, arr.length - 1));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 8,10,18}; // worst case for quicksort
        quickSort(arr2, 0, arr2.length - 1);
        print(arr2);
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] mergeSort(int[] arr, int left, int right){
        if (left < right){
            int m = left + (right - left) / 2;
            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);
            return merge(arr, left, m, right);
        } else {
            return arr;
        }
    }

    public static int[] merge(int[] arr, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] arrayLeft = new int[n1];
        int[] arrayRight = new int[n2];

        for (int i = 0; i < n1; i++){
            arrayLeft[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++){
            arrayRight[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2){
            if (arrayLeft[i] <= arrayRight[j]){
                arr[k] = arrayLeft[i];
                i++;
            } else{
                arr[k] = arrayRight[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            arr[k] = arrayLeft[i];
            i++;
            k++;
        }

        while (j < n2){
            arr[k] = arrayRight[j];
            k++;
            j++;
        }
        return arr;
    }



    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++){
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return (i + 1);
    }

}
