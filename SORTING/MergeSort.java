public class MergeSort
{
    // Merge Sort uses Depth First technique -- T.C. - O(nlog n) -- S.C. - O(n)
    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        // while (i <= mid && j <= ei) {
        for (; i <= mid && j <= ei;) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // while (i <= mid) {
        for (; i <= mid;) {
            temp[k++] = arr[i++];
        }
        // while (j <= ei) {
        for (; j <= ei;) {
            temp[k++] = arr[j++];
        }

        for (i = si, k = 0; k <= temp.length - 1; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] arr = { 5, 9, 7, 2, 3, 4, 1, 8, 3, 2, 6, 4 };
        System.out.println("Before Sorting:");
        printArr(arr);
        System.out.println();
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After Sorting");
        printArr(arr);
        
    }
}