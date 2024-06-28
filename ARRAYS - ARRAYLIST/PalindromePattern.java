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

public class PalindromePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of test cases: ");
        int test = sc.nextInt();

        while (test-- > 0) {
            System.out.println("Enter the size of matrix: ");
            int size = sc.nextInt();

            int arr[][] = new int[size][size];

            // Consuming the newline character left by nextInt()
            sc.nextLine();

            System.out.println("Enter the string of values of the matrix, with space-separated integers: ");
            String input = sc.nextLine();

            // Validate that the input contains only 0s and 1s
            if (!input.matches("[01\\s]*")) {
                System.out.println("Sorry! Your string contains values, other than 0 or 1.");
            } 
            // Validate the input length matches the expected size of the matrix
            else if (input.trim().split("\\s+").length != (size * size)) {
                System.out.println("Your string does not contain the exact number of elements required for the matrix formation.");
            } 
            else {
                // Parse the input values into the matrix
                String[] values = input.trim().split("\\s+");
                int c = 0;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        arr[i][j] = Integer.parseInt(values[c]);
                        c++;
                    }
                }

                // Find and print the result
                String result = pattern(arr, size);
                System.out.println(result);
            }
        }

        sc.close();
    }

    /**
     * This method checks for the palindrome pattern in rows first, then in columns.
     * @param arr - the 2D array of integers
     * @param n - the size of the matrix
     * @return - a string indicating the index and whether the palindrome is in a row (R) or column (C)
     */
    public static String pattern(int[][] arr, int n) {
        // Check each row for palindrome
        for (int i = 0; i < n; i++) {
            if (isPalindrome(arr, i, 0, n - 1)) {
                return i + " " + "R";
            }
        }

        // Check each column for palindrome
        for (int i = 0; i < n; i++) {
            if (isPalindromeColumn(arr, i, 0, n - 1)) {
                return i + " " + "C";
            }
        }

        // If no palindromes are found, return "-1"
        return "-1";
    }

    /**
     * This method checks if a given row is a palindrome.
     * @param arr - the 2D array of integers
     * @param row - the index of the row to check
     * @param start - the starting index
     * @param end - the ending index
     * @return - true if the row is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int[][] arr, int row, int start, int end) {
        while (start <= end) {
            if (arr[row][start] != arr[row][end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * This method checks if a given column is a palindrome.
     * @param arr - the 2D array of integers
     * @param col - the index of the column to check
     * @param start - the starting index
     * @param end - the ending index
     * @return - true if the column is a palindrome, false otherwise
     */
    public static boolean isPalindromeColumn(int[][] arr, int col, int start, int end) {
        while (start <= end) {
            if (arr[start][col] != arr[end][col]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
