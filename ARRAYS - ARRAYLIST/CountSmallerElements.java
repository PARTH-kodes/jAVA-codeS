/* 
 * Given an array arr containing non-negative integers. Count and return an array ans where ans[i] denotes the number of smaller elements on right side of arr[i].

Examples:

Input: arr[] = [12, 1, 2, 3, 0, 11, 4]
Output: [6, 1, 1, 1, 0, 1, 0]
Explanation: There are 6 smaller elements right after 12. There is 1 smaller element right after 1. And so on.
Input: arr[] = [1, 2, 3, 4, 5]
Output: [0, 0, 0, 0, 0]
Explanation: There are 0 smaller elements right after 1. There are 0 smaller elements right after 2. And so on.

 */
import java.util.*;
import java.io.*;

class Pair {

    int value;
    int index;

    Pair(int value, int index) {

        this.value = value;

        this.index = index;

    }

}
class CountSmallerElements {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of test cases: ");

        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            System.out.println("Enter the space-seperated elements: ");

            String []s = br.readLine().trim().split(" ");

            int arr[] = new int[s.length];

            for (int i = 0; i < s.length; i++) {

                arr[i] = Integer.parseInt(s[i]);

            }

            int ans[] = constructLowerArray(arr);

            System.out.println(Arrays.toString(ans));

        }

        br.close();

    }
    public static int[] constructLowerArray(int[] arr) {

        int n = arr.length;

        int[] result = new int[n];

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {

            pairs[i] = new Pair(arr[i], i);

        }

        mergeSort(pairs, result, 0, n - 1);

        return result;

    }

    private static void mergeSort(Pair[] pairs, int[] result, int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = left + (right - left) / 2;

        mergeSort(pairs, result, left, mid);

        mergeSort(pairs, result, mid + 1, right);

        merge(pairs, result, left, mid, right);

    }

    private static void merge(Pair[] pairs, int[] result, int left, int mid, int right) {

        int n = right - left + 1;

        Pair[] temp = new Pair[n];

        int i = left, j = mid + 1, k = 0;

        int rightCount = 0;

        while (i <= mid && j <= right) {

            if (pairs[i].value > pairs[j].value) {

                rightCount++;

                temp[k++] = pairs[j++];

            } else {

                result[pairs[i].index] += rightCount;

                temp[k++] = pairs[i++];

            }

        }

        while (i <= mid) {

            result[pairs[i].index] += rightCount;

            temp[k++] = pairs[i++];
        }

        while (j <= right) {

            temp[k++] = pairs[j++];

        }

        for (i = left; i <= right; i++) {

            pairs[i] = temp[i - left];

        }

    }

}