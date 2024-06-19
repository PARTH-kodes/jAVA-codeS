
public class Knapsack01 {
    public static int knapsackMemo(int price[], int wt[], int W, int indx, int dp[][]) { // USING MEMOIZATION
        if (W == 0 || indx == price.length) {
            return 0;
        }
        if (dp[indx][W] != -1) {
            return dp[indx][W];
        }
        if (wt[indx] <= W) {
            return dp[indx][W] = Math.max(price[indx] + knapsackMemo(price, wt, W - wt[indx], indx + 1, dp),
                    knapsackMemo(price, wt, W, indx + 1, dp));
        } else {
            return dp[indx][W] = knapsackMemo(price, wt, W, indx + 1, dp);
        }
    }
    
    public static int knapsackTab(int price[], int wt[], int W) {
        int dp[][] = new int[price.length + 1][W + 1]; /*
                                                        * dp[i][j] is a particular element which stores tha maximum
                                                        * profit possible when i-items are available to put inside the
                                                        * knapsack of maximum possible weight-j
                                                        */

        for (int i = 0; i < dp.length; i++) { /*
                                               * intialising the first column as 0, the first column means, that the
                                               * maximum allowable knapsack weight = W = 0, there no profit can be done.
                                               */
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) { /*
                                                  * initialising the first row as 0, the first row means, that no item
                                                  * has been selected to put inside the knapsack, which means that no
                                                  * profit is made at that moment
                                                  */
            dp[0][j] = 0;
        }
        /*
         * this nested loop system, fills the dp[][] array for each (i, j) cell with
         * that moment, maximum possible profit.
         */
        for (int i = 1; i < dp.length; i++) { /*
                                               * i and j of this loop are used to traverse the ap array, and thence are
                                               * 1 pointer ahead of the price and wt arrays, therefore we write i-1 and
                                               * j-1 in order to access the ith and jth values of the price and wt
                                               * arrays.
                                               */
            for (int j = 1; j < dp[0].length; j++) {
                int prce = price[i - 1]; // the price of the current selected item
                int weight = wt[i - 1]; // the weight of the same item

                if (weight <= j) { // valid condition
                    int incProfit = prce + dp[i - 1][j - weight]; /*
                                                                   * if the i-th item is selected(included), profit in
                                                                   * that case will be the price of that item + max.
                                                                   * profit in case of same items, but remaining
                                                                   * weight,(j-weight) is the remaining knapsack wt
                                                                   * after including the current item
                                                                   */

                    int excProfit = dp[i - 1][j]; /*
                                                   * if the i-th item is not selected, the knapsack weight remains
                                                   * unchanged
                                                   */
                    dp[i][j] = Math.max(incProfit, excProfit); /*
                                                                * finding the scneario of max. profit wheter by
                                                                * including or excluding the item.
                                                                */
                } else { /*
                          * invalid, the weight of current item is more than the possible knapsack weight
                          * for the moment, so the only choice is not exclude the current item.
                          */
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // printDP(dp);
        return dp[price.length][W]; /*
                                     * the last most cell of the dp array stores the maxprofit, when all the items
                                     * are considered for the given maximum weight of knapsack = W.
                                     */
    }

    // private static void printDP(int dp[][]) {
    // for (int i = 0; i < dp.length; i++) {
    // for (int j = 0; j < dp[0].length; j++) {
    // System.out.print(dp[i][j] + " ");
    // }
    // System.out.println();
    // }
    // System.out.println();
    // }

    public static int knapsack(int price[], int wt[], int W, int indx) { // USING RECURSION

        // base case
        if (W == 0 || indx == price.length) {
            return 0;
        }

        if (wt[indx] <= W) {
            // include
            return Math.max(price[indx] + knapsack(price, wt, W - wt[indx], indx + 1),
                    knapsack(price, wt, W, indx + 1));
            // exclude
        } else {
            return knapsack(price, wt, W, indx + 1);
        }
    }

    public static void main(String[] args) {
        int price[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[price.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("RECURSION: " + knapsack(price, wt, W, 0));
        System.out.println("MEMOISATION: " + knapsackMemo(price, wt, W, 0, dp));
        System.out.println("TABULAR METHOD: " + knapsackTab(price, wt, W));
    }
}