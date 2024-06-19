import java.util.*;


/* Given a positive integer n. Your task is to generate a string list of all n-bit binary numbers where, for any prefix of the number, there are more or an equal number of 1's than 0's. The numbers should be sorted in decreasing order of magnitude.

Example 1:

Input:  
n = 2
Output: 
{"11", "10"}
Explanation: Valid numbers are those where each prefix has more 1s than 0s:
11: all its prefixes (1 and 11) have more 1s than 0s.
10: all its prefixes (1 and 10) have more 1s than 0s.
So, the output is "11, 10".
Example 2:

Input:  
n = 3
Output: 
{"111", "110", "101"}
Explanation: Valid numbers are those where each prefix has more 1s than 0s.
111: all its prefixes (1, 11, and 111) have more 1s than 0s.
110: all its prefixes (1, 11, and 110) have more 1s than 0s.
101: all its prefixes (1, 10, and 101) have more 1s than 0s.
So, the output is "111, 110, 101". */


public class NBitBinary {
    public static ArrayList<String> allBinary(int N) {
        ArrayList<String> arr = new ArrayList<>();
        backtrack("", 0, 0, N, arr);
        return arr;
    }

    public static void backtrack(String str, int ones, int zeros, int n, ArrayList<String> result) {
        if (str.length() == n) {
            result.add(str.toString());
            return;
        }

        /*
         * for Ascending Order
         * if (ones > zeros) {
         * backtrack(str + "0", ones, zeros + 1, n, result);
         * }
         */

        if (str.length() < n) {
            backtrack(str + "1", ones + 1, zeros, n, result);
        }

        /*
         * for Descending Order
         * if (ones > zeros) {
         * backtrack(str + "0", ones, zeros + 1, n, result);
         * }
         */

    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = allBinary(n);
        for (String string : arr) {
        System.out.print(string + " ");
        }
        System.out.println();
        sc.close();
    }
}