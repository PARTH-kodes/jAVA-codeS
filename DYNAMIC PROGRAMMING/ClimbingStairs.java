import java.util.*;

public class ClimbingStairs {

    public static int countWays(int n) { // USING RECURSION
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return countWays(n - 1) + countWays(n - 2);
    }

    public static long countWays1(int n, long memo[]) { // USING MEMOIZATION
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = countWays1(n - 1, memo) + countWays1(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long memo[] = new long[n + 1];
        // System.out.println("RECURSION: " + countWays(n));
        System.out.println("MEMOIZATION: " + countWays1(n, memo));

        sc.close();
    }
}