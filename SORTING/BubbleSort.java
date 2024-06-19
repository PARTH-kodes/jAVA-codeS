public class BubbleSort {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (swaps == 0) {
                System.out.println("Already sorted array: ");
                printArray(arr);
                return;
            }
        }
        printArray(arr);
    }
    public static void main(String[] args) {
        int[] arr = { 4, 8, 9, 2, 4, 3, 5, 4, 6, 0, 0, 2, 8, 7, 3, 3, 6, 5, 7, 9 };

        bubbleSort(arr);
    }
}