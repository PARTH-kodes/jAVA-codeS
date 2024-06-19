public class CountingSort {
    public static void countingSort(int arr[]) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Integer.max(arr[i], max);
        }
        int count[] = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;

        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

        printArray(arr);
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 8, 9, 2, 4, 3, 5, 4, 6, 0, 0, 2, 8, 7, 3, 3, 6, 5, 7, 9 };

        countingSort(arr);
    }
}