package ds.program.dp;

import java.util.Scanner;
/*
You are given two strings, A and B. Answer, what is the smallest number of operations you need to
transform A to B?

Operations are:

Delete one letter from one of strings
Insert one letter into one of strings
Replace one of letters from one of strings with another letter
Input
T - number of test cases

For each test case:

String A
String B
Both strings will contain only uppercase characters and they won't be longer than 2000 characters.

There will be 10 test cases in data set.

Output
For each test case, one line, minimum number of operations.

Example
Input:
1
FOOD
MONEY

Output:
4
 */
public class MinEditDistanceAddDelUpdate {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String str1 = sc.next();
            String str2 = sc.next();
            MinEditDistanceAddDelUpdate obj = new MinEditDistanceAddDelUpdate();
            System.out.println("Case " + (t + 1) + ": " + obj.minEditDistance(str1, str2));
        }
    }

    public int minEditDistance(String a, String b) {
        if (a == null) return b != null ? b.length() : 0;
        if (b == null) return a.length();

        int m = a.length();
        int n = b.length();
        if (m == 0) return n;
        if (n == 0) return m;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
