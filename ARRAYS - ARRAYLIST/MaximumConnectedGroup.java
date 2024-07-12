/*
You are given a square binary grid. A grid is considered binary if every value in the grid is either 1 or 0. You can change at most one cell in the grid from 0 to 1. You need to find the largest group of connected  1's. Two cells are said to be connected if both are adjacent(top, bottom, left, right) to each other and both have the same value.

Examples :

Input: grid = [1, 1]
             [0, 1]
Output: 4
Explanation: By changing cell (2,1), we can obtain a connected group of 4 1's
[1, 1]
[1, 1]
Input: grid = [1, 0, 1]
             [1, 0, 1]
             [1, 0, 1]
Output: 7
Explanation: By changing cell (3,2), we can obtain a connected group of 7 1's
[1, 0, 1]
[1, 0, 1]
[1, 1, 1]

*/
// import java.io.*;
import java.util.*;

class MaximumConnectedGroup {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T-- > 0){

            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
        
            int ans = MaxConnection(grid);
            System.out.println(ans);
        }
        sc.close();
    }

    public static int dfs(int[][] grid, int i, int j, int n, int islandNo) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || grid[i][j] == islandNo) {
            return 0;
        }
        grid[i][j] = islandNo;
        int a = dfs(grid, i - 1, j, n, islandNo);
        int b = dfs(grid, i, j - 1, n, islandNo);
        int c = dfs(grid, i + 1, j, n, islandNo);
        int d = dfs(grid, i, j + 1, n, islandNo);
        return a + b + c + d + 1;
    }

    public static int MaxConnection(int[][] grid) {
        int n = grid.length;
        int islandNo = 2;  // Start labeling islands from 2
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // First pass: identify and label all islands with unique numbers and store their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, n, islandNo);
                    map.put(islandNo, size);
                    ans = Math.max(ans, size);
                    islandNo++;
                }
            }
        }
        
        // Second pass: check each zero and see if flipping it connects the maximum number of islands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    if (i > 0 && grid[i - 1][j] > 1) {
                        set.add(grid[i - 1][j]);
                    }
                    if (i < n - 1 && grid[i + 1][j] > 1) {
                        set.add(grid[i + 1][j]);
                    }
                    if (j > 0 && grid[i][j - 1] > 1) {
                        set.add(grid[i][j - 1]);
                    }
                    if (j < n - 1 && grid[i][j + 1] > 1) {
                        set.add(grid[i][j + 1]);
                    }
                    int maxSize = 1;  // Start with 1 to account for the flipped cell itself
                    for (Integer s : set) {
                        maxSize += map.get(s);
                    }
                    ans = Math.max(maxSize, ans);
                }
            }
        }
        return ans;
    }
}

