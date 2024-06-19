import java.util.*;


/* Given two integer arrays a of size n and b of size m, the task is to find the numbers which are present in the first array a, but not present in the second array b.

Note: Numbers to be returned should in order as they appear in array a.

Example 1:

Input: 
n = 6, m = 5
a[] = {1, 2, 3, 4, 5, 10}
b[] = {2, 3, 1, 0, 5}
Output: 
4 10
Explanation: 
4 and 10 are present in first array, but not in second array. */


public class MissinginSecond {
    public static ArrayList<Integer> findMissing(int[] a, int[] b, int n, int m) {
        ArrayList<Integer> missing = new ArrayList<>();
        Set<Integer> setB = new HashSet<>();
        // int c[] = new int[n];
        for (int i = 0; i < m; i++) {
            // Integer/ temp = b[i];
            setB.add(b[i]);
        }
        // int k = 0;
        for (int i = 0; i < n; i++) {
            // Integer temp = a[i];
            if (!setB.contains(a[i])) {
                missing.add(a[i]);
            }
        }
        // missing.clear();
        // for (int j = 0; j < k; j++) {
        // Integer temp = c[j];
        // missing.add(temp);
        // }
        return missing;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 1, -6, 7, 6, -7 };
        int[] b = { -3, 2, -8, 9, -3, -9 };
        ArrayList<Integer> result = findMissing(a, b, a.length, b.length);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}