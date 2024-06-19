public class MinimumRow {
    public static int minRow(int arr[][], int n, int m) {
        int mincount = Integer.MAX_VALUE, currcount = 0;
        int minrow = 0;
        for (int i = 0; i < n; i++) {
            currcount = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    currcount++;
                }
            }
            if (currcount < mincount) {
                minrow = i + 1;
                mincount = currcount;
            }
        }
        return minrow;
    }
    public static void main(String[] args) {
        int arr[][] = { { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };
        System.out.println(minRow(arr, 4, 4));
    }
}