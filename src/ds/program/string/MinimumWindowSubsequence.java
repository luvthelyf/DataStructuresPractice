package ds.program.string;

import java.util.Arrays;
// -1 1 2 3 4 -1 0 4
//
// fixed window
// dynamic window


public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        System.out.println((new MinimumWindowSubsequence()).minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String S, String T) {
        if (S == null || T == null || S.isEmpty() || T.isEmpty())
            return "";


        int SLen = S.length();
        int TLen = T.length();
        int[][] dp = new int[SLen][TLen];
        for (int i = 0; i < SLen; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < SLen; i++) {
            if (S.charAt(i) == T.charAt(0))
                dp[i][0] = i;
            else if (i > 0)
                dp[i][0] = dp[i - 1][0];
        }

        for (int i = 1; i < SLen; i++) {
            for (int j = 1; j < TLen; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//        printDp(dp);
        int len = Integer.MAX_VALUE;
        int start = -1;
        for (int i = 0; i < SLen; i++) {
            int index = dp[i][TLen - 1];
            if(index != -1) {
                if(len > i - index + 1) {
                    start = index;
                    len = i - index + 1;
                }
            }
        }

        if(start == -1) return "";

        return S.substring(start, start + len);

    }

    private void printDp(int[][] dp) {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] +"\t");

            }
            System.out.println();
        }
    }
}
