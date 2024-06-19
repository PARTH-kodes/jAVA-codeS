public class SelectionSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[pos] > arr[j]) {
                    pos = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
        printArray(arr);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 8, 9, 2, 4, 3, 5, 4, 6, 0, 0, 2, 8, 7, 3, 3, 6, 5, 7, 9 };

        selectionSort(arr);
    }
}