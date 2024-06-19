// import java.io.*;
import java.util.*;

public class PalindromicPartitioning {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter your string :");
            String str = sc.nextLine();
            System.out
                    .println("After " + palindromicPartition(str) + " partitioning, palindromic substrings are found.");
        }
        sc.close();
    }

    static int palindromicPartition(String str) {
        int n = str.length();
        int arr[] = new int[n + 1];
        arr[0] = 0;

        for (int i = 0; i < n; i++) {
            int min = (int) (1e9);
            for (int j = i; j >= 0; j--) {
                if (inPalindrome(j, i, str)) {
                    int res = 1 + arr[j];
                    min = Math.min(res, min);
                }
            }
            arr[i + 1] = min;
        }
        return arr[n] - 1;
    }

    static boolean inPalindrome(int i, int j, String str) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}