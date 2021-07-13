package ds.program.array.matrix;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(Arrays.deepToString((new FloodFill()).floodFill(image, 1, 1, 2)));
    }

//
//
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int color = image[sr][sc];
//        if (color != newColor) dfs(image, sr, sc, color, newColor);
//        return image;
//    }
//    public void dfs(int[][] image, int r, int c, int color, int newColor) {
//        if (image[r][c] == color) {
//            image[r][c] = newColor;
//            if (r >= 1) dfs(image, r-1, c, color, newColor);
//            if (c >= 1) dfs(image, r, c-1, color, newColor);
//            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
//            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
//        }
//    }
//
    int dirX[] = {0, 1, 0, -1};
    int dirY[] = {1, 0, -1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor)
            floodFillUtil(image, image[sr][sc], sr, sc, newColor);
        return image;
    }
    public int[][] floodFillUtil(int[][] image, int initColor, int x, int y, int newColor) {
       image[x][y] = newColor;
       for (int dir = 0; dir < 4; dir++) {
            int dx = x + dirX[dir];
            int dy = y + dirY[dir];
            if (dx >= 0 && dx < image.length && dy >= 0 && dy < image[0].length) {
                if (image[dx][dy] == initColor) {
                    floodFillUtil(image, initColor, dx, dy, newColor);
                }
            }

        }
        return image;
    }
}
