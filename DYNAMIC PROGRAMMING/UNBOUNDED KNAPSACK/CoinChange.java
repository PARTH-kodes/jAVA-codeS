public class CoinChange {
    public static int changeWays(int coins[], int change, int indx) {
        if (indx == coins.length) {
            if (change == 0) {
                return 1;
            }
            return 0;
        }
        if (coins[indx] <= change) {
            int sum1 = changeWays(coins, change - coins[indx], indx + 1);
            int sum2 = changeWays(coins, change - coins[indx], indx);

            return sum1 + sum2;
        } else {
            return changeWays(coins, change, indx + 1);
        }
    }

    public static int changeWaysTab(int coins[], int change) {
        int dp[][] = new int[coins.length + 1][change + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1; /*
                           * if we as much coins, but we do not have to return any change, then there is
                           * one way only of not giving anything
                           */
        }
        /*
         * similarly if we have no coins, but have to give the change, then it is not
         * possible and nummber of ways will be only 0
         */

        for (int coin = 1; coin < coins.length + 1; coin++) {
            for (int CHANGE = 1; CHANGE < change + 1; CHANGE++) {
                if (coins[coin - 1] <= CHANGE) {
                    dp[coin][CHANGE] = dp[coin][CHANGE - coins[coin - 1]] + dp[coin - 1][CHANGE];
                } else {
                    dp[coin][CHANGE] = dp[coin - 1][CHANGE];
                }
            }
        }
        return dp[coins.length][change];
    }

    public static void main(String[] args) {
        int coins[] = { 2, 3, 5, 6 };
        int change = 10;
        // System.out.println(changeWays(coins, change, 0));
        System.out.println(changeWaysTab(coins, change));
    }
}