/* Given an array of N integers, find the sum of xor of all pairs of numbers in the array arr. In other words, select all possible pairs of i and j from 0 to N-1 (i<j) and determine sum of all (arri xor arrj).

Example 1:

Input : arr[ ] = {7, 3, 5}
Output : 12
Explanation:
All possible pairs and there Xor
Value: ( 3 ^ 5 = 6 ) + (7 ^ 3 = 4)
 + ( 7 ^ 5 = 2 ) =  6 + 4 + 2 = 12
Example 2:

Input : arr[ ] = {5, 9, 7, 6} 
Output :  47
Explanation:
All possible pairs and there Xor
Value: (5 ^ 9 = 12) + (5 ^ 7 = 2)
 + (5 ^ 6 = 3) + (9 ^ 7 = 14)
 + (9 ^ 6 = 15) + (7 ^ 6 = 1)
 = 12 + 2 + 3 + 14 + 15 + 1 = 47*/

import java.io.*;
import java.util.*;

class SumXORpairs {

    // Driver code
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter \"1\" to know what does the program do");
        int choice = sc.nextInt();
        String choices = "";

        if (choice == 1) {
            System.out.println(
                    "This program finds the sum of XOR of all pairs of numbers in the array.\n");
            System.out.println("Enter \"Yes\" to continue with the program.\nElse Enter \"No\" to terminate.");
            choices = sc.next();
        }
        if ("YES".equalsIgnoreCase(choices)) {
            System.out.println("Enter the number of test cases");
            int testcases = sc.nextInt();

            while (testcases-- > 0) {
                System.out.print("Enter the size of the array : ");
                int sizeOfArray = sc.nextInt();
                System.out.println("Enter the elements of the array: ");
                int arr[] = new int[sizeOfArray];

                for (int i = 0; i < sizeOfArray; i++) {
                    arr[i] = sc.nextInt();
                }

                SumXORpairs obj = new SumXORpairs();
                long res = obj.sumXOR(arr, sizeOfArray);
                System.out.println(res);
            }
        } else {
            System.out.println("PROGRAM TERMINATED");
        }
        sc.close();
    }

    public long sumXOR(int arr[], int n) {

        long result = 0;

        for (int i = 0; i < 32; i++) {
            long set_bits = 0;
            long unset_bits = 0;

            long bit_checker = 1 << i;

            for (int idx = 0; idx < n; idx++) {
                if ((arr[idx] & bit_checker) == 0) {
                    unset_bits++;
                } else {
                    set_bits++;
                }
            }

            long total_xors = set_bits * unset_bits;

            long bit_sum = total_xors * bit_checker;

            result += bit_sum;

        }

        return result;
    }
}
