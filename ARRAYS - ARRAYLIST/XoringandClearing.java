/* You are given an array arr[] of size n. You need to do the following:

You need to calculate the bitwise XOR of each element in the array with its corresponding index (indices start from 0).
After step1, print the array.
Now, set all the elements of arr[] to zero.
Now, print arr[]. */

public class XoringandClearing {

    public static void printArr(int n, int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void setZero(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            arr[i] = 0;
        }
        printArr(n, arr);
    }

    public static void xor1toN(int n, int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ i;
        }
        printArr(n, arr);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        xor1toN(arr.length, arr);
        setZero(arr.length, arr);
    }
}