package ds.program.lc.hard;

/**
 *
 * 980. Unique Paths III
 * Hard
 *
 * 1419
 *
 * 92
 *
 * Add to List
 *
 * Share
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 *
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 *
 *
 * Note:
 *
 * 1 <= grid.length * grid[0].length <= 20
 */

public class UniquePath3 {
    public static void main(String[] args) {
//        System.out.println(new UniquePath3().uniquePathsIII(new int[][]{{0,1},{2,0}}));
        System.out.println(new UniquePath3().uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
    }
    int ans = 0;
    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        int totalNonZero = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if(grid[i][j] >= 0) {
                    totalNonZero++;
                }
            }
        }

        backtrack(startX, startY, grid, totalNonZero);

        return ans;
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    private void backtrack(int row, int col, int[][] grid, int remaining) {

        if(grid[row][col] == 2 && remaining == 1) {
            ans += 1;
            return;
        }

        int temp = grid[row][col];
        grid[row][col] = -2;

        for(int i = 0; i < 4; i++) {
            int r = row + dx[i];
            int c = col + dy[i];

            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) continue;

            if(grid[r][c] < 0) continue;

            backtrack(r, c, grid, remaining - 1);
        }

        grid[row][col] = temp;

    }
}
