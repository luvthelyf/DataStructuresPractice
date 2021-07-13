package ds.program.dp;

import java.util.Scanner;

public class MaximalSquareArea {
    public static void main(String[] arg) {
        char[][] arr = {
                {'0'},
//                {'0'}
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '1', '1', '1'}
        };
        MaximalSquareArea obj = new MaximalSquareArea();
        System.out.println("Case " + ": " + obj.maximalSquare(arr));

    }

    public int maximalSquare(char[][] arr) {
        if (arr.length == 0) return 0;
        int x = arr.length;
        int y = arr[0].length;
        int[][] dp = new int[x][y];
        int ans = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || j == 0) {
                    if (arr[i][j] == '1') {
                        dp[i][j] = 1;
                    }
                } else {
                    if (arr[i][j] == '1')
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;

                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }
}
