package ds.program.array;

import java.util.HashMap;

public class TwoSubsetWithEqualSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 2, 1};

        System.out.println(findPartition(arr));
    }

    private static boolean findPartition(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int value : arr) sum += value;
        if (sum % 2 != 0) return false;
        int searchSum = sum / 2;
        boolean[][] dp = new boolean[searchSum + 1][len + 1];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
           // map.put()
        }
        for (int i = 0; i <= len; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= searchSum; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= searchSum; i++) {
            for (int j = 1; j <= len; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
                }
            }
        }

        for (int i = 0; i <= searchSum + 1; i++) {
            for (int j = 0; j <= len + 1; j++) {
                if(i == 0 && j == 0) {
                    System.out.print("\t");
                    continue;
                }
                if(i == 0)
                    System.out.print((j - 1) + "\t\t");
                else if(j == 0)
                    System.out.print((i-1)+"\t");
                else
                    System.out.print(dp[i - 1][j - 1] + "\t");
            }
           System.out.println();
        }

        return dp[searchSum][len];
    }
}
