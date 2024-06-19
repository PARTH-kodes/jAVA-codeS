public class Recursion {
    public static void decOrder(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
            return;
        }
        // decOrder(n - 1); // -- Increasing order( 1 -> 2 -> 3 -> ... -> n)
        System.out.print(n + " ");
        decOrder(n - 1); // -- Decreasing order (n -> n-1 -> n-2 -> ... -> 1)
    }

    public static int nFactorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * nFactorial(n - 1);
    }

    public static int sumOfn(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfn(n - 1);
    }

    public static long nFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return nFibonacci(n - 2) + nFibonacci(n - 1);
    }

    public static void nFiboSeries(int n) {
        int i = 0, j = 1;
        int arr[] = new int[n + 1];
        arr[0] = i;
        arr[1] = j;
        for (int t = 2; t < n + 1; t++) {
            arr[t] = (int) ((i + j) % (1e9 + 7));
            i = j;
            j = arr[t];
        }
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }

    public static boolean isSorted(int arr[], int indx) {
        if (indx == arr.length - 1) {
            return true;
        } else if (arr[indx] < arr[indx + 1]) {
            return isSorted(arr, indx + 1);
        }
        return false;
    }

    public static int firstOccur(int arr[], int indx, int key) {
        if (key == arr[indx]) {
            return indx;
        }
        while (indx != arr.length - 1) {
            return firstOccur(arr, indx + 1, key);
        }
        return -1;
    }

    public static int lastOccur(int arr[], int indx, int key) {
        if (key == arr[indx]) {
            return indx;
        }
        while (indx > 0) {
            return lastOccur(arr, indx - 1, key);
        }
        return -1;
    }

    public static int powerOf(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * powerOf(x, n - 1);
    }

    public static long isPoweropt(int x, int n) {
        if (n == 0) {
            return 1;
        }
        long halfPower = isPoweropt(x, n / 2);
        long halfPowerSq = halfPower * halfPower;

        return ((n & 1) == 1) ? x * halfPowerSq : halfPowerSq;
    }

    public static void nonConsecutiveOnes(int n, int lastPlace, StringBuilder str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        nonConsecutiveOnes(n - 1, 0, str.append("0"));
        str.deleteCharAt(str.length() - 1);
        if (lastPlace == 0) {
            nonConsecutiveOnes(n - 1, 1, str.append("1"));
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        // int[] arr = {6, 1, 2, 3, 4, 5 }; // -- any sorted or unsorted array
        // decOrder(10);

        // System.out.println(nFactorial(5));

        // System.out.println(sumOfn(10));

        // System.out.println(nFibonacci(1)); // based on 0 indexing

        // nFiboSeries(10);

        // System.out.println(isSorted(arr, 0));

        // System.out.println(firstOccur(arr, 0, 6));

        // System.out.println(lastOccur(arr, rr.length - 1, 6));

        // System.out.println(powerOf(5, 4));

        // System.out.println(isPoweropt(2, 62));

        // nonConsecutiveOnes(3, 0, new StringBuilder("")); // -- print all binary
        // strings of
        // size N without consecutive 1.

    }
}