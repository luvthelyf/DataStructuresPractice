package ds.program;

import java.util.HashMap;
import java.util.HashSet;

public class IslandProblem {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
//int[][] arr = {{0,0,0,0,0,0,0,0}};
//        int arr[][] = {
//                {1, 0, 1},
//                {1, 1, 1},
//                {0, 0, 1}};

        System.out.println(new IslandProblem().numberOfIsland(arr));
    }

    int area = 0;
    int count = 0;

    private boolean triplet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = -(arr[i] + arr[j]);
                if (set.contains(sum)) {
                    return true;
                }
                set.add(arr[j]);
            }
        }
        return false;
    }
    private int numberOfIsland(int[][] arr) {
        if (arr.length == 0) return 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) { //O(MXN)
                if (arr[i][j] == 1) {
                    count = 0;
                    markAdjacentElements(arr, i, j);
                    area = Math.max(area, count);
                }
            }
        }
        return area;
    }

    int[] dx = new int[]{0, 1, 0,-1};
    int[] dy = new int[]{1, 0, -1, 0};

    private void markAdjacentElements(int[][] arr, int row, int col) {
        arr[row][col] = 0;
        count++;
        for (int i = 0; i < 4; i++) {
            int r = row + dx[i];
            int c = col + dy[i];

            if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length) {
                if (arr[r][c] == 1) {
                    markAdjacentElements(arr, r, c);
                }
            }
        }

    }
}
