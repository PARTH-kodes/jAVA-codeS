public class GridWays {
    static int mod = (int) 1e9 + 7;

    public static int possibleWays(int i, int j) { // using recursion approach
        // base case
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i == -1 || j == -1) {
            return 0;
        }

        // recursion
        return possibleWays(i - 1, j) + possibleWays(i, j - 1);
    }

    public static int countWays(int n, int m) { // using mathematical approach of permutations and combinations
        long noOfWays = 0;

        // noOfWays = (factorial(n + m - 2)) / (factorial(n - 1) * factorial(m - 1));

        noOfWays = (((factorial(n + m)) % mod) / ((factorial(n) % mod) * (factorial(m)) % mod)) % mod;

        return (int) noOfWays;

    }

    private static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return (n * factorial(n - 1)) % mod;
    }

    public static void main(String[] args) {
        // System.out.println(possibleWays(7, 6));
        System.out.println(countWays(7, 6));
    }
}