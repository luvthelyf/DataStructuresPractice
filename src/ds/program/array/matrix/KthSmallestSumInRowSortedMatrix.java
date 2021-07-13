package ds.program.array.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestSumInRowSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,11},{2,4,6}};
       // int[][] matrix = {{1,10,10},{1,4,5},{2,3,6}}; // k =7


        KthSmallestSumInRowSortedMatrix obj = new KthSmallestSumInRowSortedMatrix();

        System.out.println(obj.kthSmallest(matrix, 9));
    }
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        List<Integer> level = new ArrayList<>();
        level.add(0);

        for(int i = 0; i < m; i++) {
            List<Integer> nextLevel = new ArrayList<>();

            for(int j = 0; j < n; j++) {
                for(int p = 0; p < Math.min(k, level.size()); p++) {
                    System.out.println(mat[i][j] +" "+ level.get(p));
                    nextLevel.add(mat[i][j] + level.get(p));
                }
            }
            System.out.println(nextLevel);
            Collections.sort(nextLevel);
            level = nextLevel;
        }

        return level.get(k-1);
    }
}
