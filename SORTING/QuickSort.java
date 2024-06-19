/*
    * Quick Sort --- T.C. -> O(n logn)--- S.C. -> O(n)
    * Worst Case T.C. -> O(n^2) if the array is already sorted and pivot is the
    * largest or the smallest element
    */

public class QuickSort {

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int partitionIndx = partition(arr, si, ei);
        quickSort(arr, si, partitionIndx - 1);
        quickSort(arr, partitionIndx + 1, ei);

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 5, 9, 7, 2, 3, 4, 1, 8, 3, 2, 6, 4 };
        System.out.println("Before Sorting:");
        printArr(arr);
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After Sorting");
        printArr(arr);
    }
}