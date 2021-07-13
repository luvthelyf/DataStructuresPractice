package ds.program.array.matrix;

import java.util.Arrays;

class LongestIncreasingPathInMatrix {
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        int ans = 0;

        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                ans = Math.max(ans, 1 + longestIncreasingPathUtil(dp, matrix, i, j));

        return ans;

    }


    public int longestIncreasingPathUtil(int[][] dp, int[][] matrix, int x, int y) {

        if(dp[x][y] != 0)
            return dp[x][y];

        for(int i = 0; i < 4; i++) {
            int r = x + dx[i];
            int c = y + dy[i];

            if(isWithinBoundary(r, c, matrix.length, matrix[0].length) &&
                    matrix[x][y] < matrix[r][c]) {
                dp[x][y] = Math.max(dp[x][y], 1 + longestIncreasingPathUtil(dp, matrix, r, c));
            }
        }
        return dp[x][y];
    }

    private boolean isWithinBoundary(int r, int c, int row, int col) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
//        int mat[][] = {
//            { 1, 2, 3, 4 },
//            { 2, 2, 3, 4 },
//            { 3, 2, 3, 4 },
//            { 4, 5, 6, 7 },
//        };

        System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(mat));
    }
}