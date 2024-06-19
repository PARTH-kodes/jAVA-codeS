// import java.util.*;

/* You are given an array arr of size n. You have to remove a subarray of size k , such that the difference between the maximum and minimum values of the remaining array is minimized.
Find the minimum value obtained after performing the operation of the removal of the subarray and return it.

Example 1:

Input:
n = 5
k = 3
arr = {1, 2, 3, 4, 5}
Output: 
1
Explanation: 
We can remove first subarray of length 3(i.e. {1, 2, 3}) then remaining array will be {4,5} and the difference of maximum and minimum element will be 1 i.e 5 - 4 = 1
Example 2:

Input:
n = 6
k = 3
arr = {2, 3, 1, 4, 6, 7}
Output: 
2
Explanation:
If we remove the subarray {2,3,1} then remaining array will be {4,6,7} and the difference  = 7-4 = 3
If we remove the subarray {3,1,4} then remaining array will be {2,6,7} and the difference  = 7-2 = 5
If we remove the subarray {1,4,6} then remaining array will be {2,3,7} and the difference  = 7-2 = 5
If we remove the subarray {4,6,7} then remaining array will be {2,3,1} and the difference  = 3-1 = 2
So the answer will be min(3,5,5,2) = 2 */


public class MinimiseDifference {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // every index will contain the left max-min and right min-max element
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int[] lmin = new int[n];
        int[] rmin = new int[n];

        lmax[0] = arr[0];
        lmin[0] = arr[0];
        rmax[n - 1] = arr[n - 1];
        rmin[n - 1] = arr[n - 1];

        // forming arrays
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], arr[i]);
            lmin[i] = Math.min(lmin[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i]);
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }

        // initialize by creating for first window
        int currMin = rmin[k];
        int currMax = rmax[k];
        int ans = Integer.MAX_VALUE - 1;
        ans = Math.min(currMax - currMin, ans);
        for (int i = 1; i < n - k; i++) {
            // repeat the process while moving the window towards right
            currMin = Math.min(lmin[i - 1], rmin[i + k]);
            currMax = Math.max(lmax[i - 1], rmax[i + k]);
            ans = Math.min(currMax - currMin, ans);
        }
        // the window will left the last index so check out the last index additinally
        currMin = lmin[n - k - 1];
        currMax = lmax[n - k - 1];
        ans = Math.min(currMax - currMin, ans);
        // return the final answer
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 4, 6, 7 };
        System.out.println(minimizeDifference(6, 3, arr));
    }
}