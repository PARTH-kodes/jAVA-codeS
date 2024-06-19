/* An hourglass is of the structure
 * x x x
 *   x
 * x x x
 * so in this program we found all the poosible hourglass sum and returned it, if no hourglass exists it returns -1
 * visit: https://algo.monster/liteproblems/2428  for clear and better understanding of our approach.
  */

public class HourGlassMatrix {
    public static int findGetMax(int arr[][], int n, int m) {
        int rows = arr.length;
        int col = arr[0].length;

        int hourGlassSum = 0;
        int maxHourGlassSum = -1;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                hourGlassSum = 0;
                hourGlassSum = -arr[i][j - 1] - arr[i][j + 1];

                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        hourGlassSum += arr[x][y];
                    }
                }
                maxHourGlassSum = Integer.max(maxHourGlassSum, hourGlassSum);
            }
        }
        return maxHourGlassSum;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        int arr1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(findGetMax(arr, arr.length, arr[0].length));
        System.out.println(findGetMax(arr1, arr1.length, arr1[0].length));
    }
}