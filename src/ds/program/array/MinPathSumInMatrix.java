package ds.program.array;

import java.util.Scanner;

public class MinPathSumInMatrix {
    public static void main(String[] args) {
        int arr[][] =
                {
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}
                };
//                {
//                        {1, 1, 5, 1, 1, 1},
//                        {1, 1, 1, 1, 1, 10},
//                        {1, 1, 1, 1, 1, 1},
//                        {1, 1, 1, 1, 1, 1},
//                        {1, 8, 1, 1, 1, 1},
//                        {1, 1, 1, 10, 1, 1}
//                };
//                {
//                        {1},
//                };
//                {
//                        {1, 2, 3},
//                        {4, 8, 2},
//                        {1, 5, 3}
//                };
                /* {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };*/

        System.out.println((new MinPathSumInMatrix()).minPathSum(arr));
    }

    int[][] dp;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];

        return dfs(grid, m - 1, n - 1);

    }

    public int dfs(int grid[][], int x, int y) {
        if (x == 0 && y == 0) return grid[0][0];
        if(x < 0 || y < 0) return Integer.MAX_VALUE;
        if (dp[x][y] > 0) return dp[x][y];

        dp[x][y] = grid[x][y] + Math.min(dfs(grid, x - 1, y), dfs(grid, x, y - 1));

        return dp[x][y];
    }

}
