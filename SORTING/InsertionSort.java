public class InsertionSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            arr[prev + 1] = curr;
        }
        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 8, 9, 2, 4, 3, 5, 4, 6, 0, 0, 2, 8, 7, 3, 3, 6, 5, 7, 9 };

        insertionSort(arr);
    }
}