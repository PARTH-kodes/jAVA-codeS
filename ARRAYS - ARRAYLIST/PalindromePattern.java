/* 
 * Given a two-dimensional integer array arr of dimensions n x n, consisting solely of zeros and ones, identify the row or column (using 0-based indexing) where all elements form a palindrome. If multiple palindromes are identified, prioritize the palindromes found in rows over those in columns. Within rows or columns, the palindrome with the smaller index takes precedence. The result should be represented by the index followed by either 'R' or 'C', indicating whether the palindrome was located in a row or column. The output should be space-separated. If no palindrome is found, return the string -1.

Examples:

Input: 
arr[][] =  [[1, 0, 0], 
           [0, 1, 0],
           [1, 1, 0]]
Output: 1 R
Explanation: In the first test case, 0-1-0 is a palindrome 
occuring in a row having index 1.
Input: 
arr[][] =   [[1, 0],
           [1, 0]]
Output: 0 C
Explanation: 1-1 occurs before 0-0 in the 0th column. And there is no palindrome in the two rows.
 */

import java.util.*;
// import java.io.*;

public class PalindromePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of test cases: ");

        int test = sc.nextInt();

        while (test-- > 0) {

            System.out.println("Enter the size of matrix: ");

            int size = sc.nextInt();

            int arr[][] = new int[size][size];

            System.out.println("Enter the string of values of the matrix, with space seperted integers: ");

            String input = sc.nextLine();

            String values[] = input.trim().split("\\s+");

            if (!input.matches("[01]*")) {

                System.out.println("Sorry! Your string contains values, other than 0 or 1.");

            } else if (values.length != (size * size)) {

                System.out.println(
                        "Your string does not contain the exact number of elements required for the matrix formation.");

            } else {

                int c = 0;

                for (int i = 0; i < size; i++) {

                    for (int j = 0; j < size; j++) {

                        arr[i][j] = Integer.parseInt(values[c]);

                        c++;

                    }

                }

                String result = pattern(arr, size);

                System.out.println(result);

            }

        }

        sc.close();

    }

    public static String pattern(int[][] arr, int n) {

        for (int i = 0; i < n; i++) {

            if (isPalindrome(arr, i, 0, n - 1)) {

                return i + " " + "R";

            }

        }

        for (int i = 0; i < n; i++) {

            if (isPalindrome2(arr, i, 0, n - 1)) {

                return i + " " + "C";

            }

        }

        return "-1";

    }

    public static boolean isPalindrome(int[][] arr, int i, int si, int ei) {

        while (si <= ei) {

            if (arr[i][si] != arr[i][ei]) {

                return false;

            }

            si++;

            ei--;

        }

        return true;

    }

    public static boolean isPalindrome2(int[][] arr, int i, int si, int ei) {

        while (si <= ei) {

            if (arr[si][i] != arr[ei][i]) {

                return false;

            }

            si++;

            ei--;

        }

        return true;

    }

}