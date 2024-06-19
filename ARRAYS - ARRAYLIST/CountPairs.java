/* Given an array arr of n integers, count all pairs (arr[i], arr[j]) in it such that i*arr[i] > j*arr[j] and 0 ≤ i < j < n.

Note: 0-based Indexing is followed.

Example 1:

Input :
n = 4
arr[] = {8, 4, 2, 1}
Output :
2
Explanation:
If we see the array after operations
[0*8, 1*4, 2*2, 3*1] => [0, 4, 4, 3]
Pairs which hold the condition i*arr[i] > j*arr[j] are (4,1) and (2,1), so in total 2 pairs are available.
Example 2:

Input :
n = 7
arr[] = {5, 0, 10, 2, 4, 1, 6}
Output:
5
Explanation :
Pairs which hold the condition i*arr[i] > j*arr[j] are (10,2), (10,4), (10,1), (2,1) and (4,1), so in total 5 pairs are there.*/

public class CountPairs {
    public static int countPairs(int arr[], int n) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * arr[i];
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        int count = 0;
        for (int j = 1; j < arr.length - 1; j++) {
            if (arr[j] == 0) {
                continue;
            }
            int curr = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                if (curr > arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 13, 13, 17, 20, 1, 12, 8, 4 };
        System.out.println(countPairs(arr, arr.length));
    }
}