// USES CONCEPT OF TREE-SET


/* Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. Return the elements in sorted order.

Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 5, arr2 [] = {1, 2, 3, 6, 7}
Output: 
1 2 3 4 5 6 7
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5 6 7.*/

import java.util.*;

public class UnionSorted {

    public static ArrayList<Integer> getUnion(int arr1[], int arr2[], int n, int m) { /*
                                                                                       * more optimised and better
                                                                                       * solution T.C. => O(n+m).
                                                                                       */
        Set<Integer> sortUnion = new TreeSet<>();
        for (int i : arr1) {
            sortUnion.add(i);
        }

        for (int i : arr2) {
            sortUnion.add(i);
        }

        return new ArrayList<>(sortUnion);
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) { /*
                                                                                        * also good approach but not
                                                                                        * optimized enough
                                                                                        */
        ArrayList<Integer> sortedUnion = new ArrayList<>();
        int i = 0, j = 0;

        // add all the common indices
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (!sortedUnion.contains(arr1[i])) {
                    sortedUnion.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] >= arr2[j]) {
                if (!sortedUnion.contains(arr2[j])) {
                    sortedUnion.add(arr2[j]);
                }
                j++;
            }
        }

        // for any remaining values in arr1[]
        while (i < n) {
            if (!sortedUnion.contains(arr1[i])) {
                sortedUnion.add(arr1[i]);
            }
            i++;
        }

        // for any remaining values in arr2[]
        while (j < m) {
            if (!sortedUnion.contains(arr2[j])) {
                sortedUnion.add(arr2[j]);
            }
            j++;
        }

        return sortedUnion;
    }

    public static void main(String[] args) {
        int arr1[] = { -8, -3, -3, -2, 0, 1, 2, 2, 6 };
        int arr2[] = { -9, -9, 0 };

        ArrayList<Integer> sortedUnion = getUnion(arr1, arr2, arr1.length, arr2.length);

        for (Integer integer : sortedUnion) {
            System.out.print(integer + " ");
        }
    }
}