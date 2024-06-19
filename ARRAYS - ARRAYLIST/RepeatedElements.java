/* You are given an integer n and an integer array arr of size n+2. All elements of the array are in the range from 1 to n. Also, all elements occur once except two numbers which occur twice. Find the two repeating numbers.
Note: Return the numbers in their order of appearing twice. So, if X and Y are the repeating numbers, and X's second appearance comes before second appearance of Y, then the order should be (X, Y).

Example 1:

Input:
n = 4
arr[] = {1,2,1,3,4,3}
Output: 
1 3
Explanation: 
In the given array, 1 and 3 are repeated two times and as 1's second appearance occurs before 2's second appearance, so the output should be 1 3. */


import java.util.HashSet;

public class RepeatedElements {
    public static int[] twoRepeated(int arr[], int n) {
        int []repeat = new int[2];
        int k = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if(!set.contains(i)){
                set.add(i);
            }else{
                repeat[k++]=i;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 1 };
        arr = twoRepeated(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}