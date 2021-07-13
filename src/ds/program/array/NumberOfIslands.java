package ds.program.array;

import java.util.Scanner;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
//                {1},
//                {1}
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        try {
            System.setSecurityManager(new SecurityManager() {
                @Override
                public void checkExit(int status) {
                    super.checkExit(status);
                    System.out.println("exception thrown");
                    throw new RuntimeException("exception thrown");
                }
            });
            System.out.println("try");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally executed");
        }
        System.out.println("number of island = " + (new NumberOfIslands()).numIslands(grid));
    }

    private int[] dirX = new int[]{0, 1, 0, -1};
    private int[] dirY = new int[]{1, 0, -1, 0};


    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        int xLen = grid.length;
        int yLen = grid[0].length;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 1/* && !visited[i][j]*/) {
//                    visited[i][j] = true;
//                    grid[i][j] = 0;
                    count++;
                    markConnected(grid, i, j, xLen, yLen);
                }
            }
        }
        return count;
    }

    public void markConnected(char[][] grid, int x, int y, int xLen, int yLen) {
        grid[x][y] = 0;
//        visited[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int dx = x + dirX[dir];
            int dy = y + dirY[dir];
            if (dx >= 0 && dx < xLen && dy >= 0 && dy < yLen) {
                if (grid[dx][dy] == 1) {
                    markConnected(grid, dx, dy, xLen, yLen);
                }
            }

        }
    }

}
