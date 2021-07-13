package ds.program.array;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String strA = sc.next();
            String strB = sc.next();
            LongestCommonSubsequence obj = new LongestCommonSubsequence();
            System.out.println("Case #" + (t + 1) + ": " + obj.longestCommonSubsequence(strA, strB));
        }
    }

    //    public int longestCommonSubsequence(String A, String B) {
//        char[] arrA = A.toCharArray();
//        char[] arrB = B.toCharArray();
//
//        int[][] dp = new int[arrA.length + 1][arrB.length + 1];
//
//        for (int i = 1; i <= arrA.length; i++) {
//            for (int j = 1; j <= arrB.length; j++) {
//                if (arrA[i - 1] == arrB[j - 1]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[arrA.length][arrB.length];
//    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        int dp[] = new int[t2.length + 1];
        for (int i = 1; i <= t1.length; i++) {
            int prev = 0;
            for (int j = 1; j <= t2.length; j++) {
                int tmp = dp[j];
                System.out.print(t1[i - 1] + "-->" + t2[j - 1]);
                if (t1[i - 1] == t2[j - 1]) dp[j] = prev + 1;
                else dp[j] = Math.max(dp[j], dp[j - 1]);
                prev = tmp;
                System.out.print("," + dp[j] + "," + prev + "\t");
            }
            System.out.println();
        }

        return dp[t2.length];
    }

    public void printDp(String A, String B, int[][] dp) {
        for (int i = 0; i <= A.length() + 1; i++) {
            for (int j = 0; j <= B.length() + 1; j++) {
                if (i == 0) {
                    if (j == 0 || j == 1) System.out.print("\t");
                    else System.out.print(B.charAt(j - 2) + "\t");

                } else if (j == 0) {
                    if (i == 1) System.out.print("\t");
                    else System.out.print(A.charAt(i - 2) + "\t");
                } else System.out.print(dp[i - 1][j - 1] + "\t");
            }
            System.out.println("\n");
        }
    }
}
