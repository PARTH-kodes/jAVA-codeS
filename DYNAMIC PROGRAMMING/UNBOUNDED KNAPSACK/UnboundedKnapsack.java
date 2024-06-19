
public class UnboundedKnapsack {
    public static int unboundMemo(int price[], int wt[], int W, int indx, int dp[][]) { // USING MEMOIZATION METHOD
        if (indx == price.length || W == 0) {
            return 0;
        }
        if (dp[indx][W] != -1) {
            return dp[indx][W];
        }
        if (wt[indx] <= W) {
            return dp[indx][W] = Math.max(
                    Math.max(price[indx] + unboundMemo(price, wt, W - wt[indx], indx + 1, dp),
                            price[indx] + unboundMemo(price, wt, W - wt[indx], indx, dp)),
                    unboundMemo(price, wt, W, indx + 1, dp));
        } else {
            return dp[indx][W] = unboundMemo(price, wt, W, indx + 1, dp);
        }
    }



    public static int unboundTab(int price[], int wt[], int W) { // USING TABULATION METHOD
        int n = price.length;
        int dp[][] = new int[n + 1][W + 1];
        // initialise 0th row and 0th column with 0 -> JAVA already fills an integer
        // array with 0s, so no need.

        for (int i = 1; i < dp.length; i++) {/*
                                              * previously 0-1knapsack we
                                              * choose 1 element and then
                                              * we move on to another, but
                                              * now we can select any
                                              * particular elemnet any
                                              * number of times, as
                                              * possible.
                                              */
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);/*
                                                                                            * therefore evne after
                                                                                            * selecting the ith element
                                                                                            * from the price array, we
                                                                                            * can still select it again
                                                                                            * among the remaining
                                                                                            * elements, so unlike
                                                                                            * 0-1knapsack where we i-1
                                                                                            * choices after selecting 1
                                                                                            * element, here we have i
                                                                                            * choices again
                                                                                            */
                } else { /* P.S. compare the if clause of both the programs. */
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int price[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(unboundTab(price, wt, W));
        System.out.println(unboundMemo(price, wt, W, 0, new int[price.length + 1][W + 1]));
    }
}