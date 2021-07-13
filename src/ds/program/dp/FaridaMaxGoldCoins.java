package ds.program.dp;
/*
Once upon time there was a cute princess called Farida living in a castle with her father, mother and uncle.
On the way to the castle there lived many monsters. Each one of them had some gold coins.
Although they are monsters they will not hurt. Instead they will give you the gold coins,
but if and only if you didn't take any coins from the monster directly before the current one.
To marry princess Farida you have to pass all the monsters and collect as many coins as possible.
Given the number of gold coins each monster has, calculate the maximum number of coins
you can collect on your way to the castle.

Input
The first line of input contains the number of test cases. Each test case starts with a number N,
the number of monsters, 0 <= N <= 10^4. The next line will have N numbers, number of coins each monster has,
 0 <= The number of coins with each monster <= 10^9. Monsters described in the order
 they are encountered on the way to the castle.

Output
For each test case print “Case C: X” without quotes. C is the case number, starting with 1.
X is the maximum number of coins you can collect.

Example
Input:
2
5
1 2 3 4 5
1
10

Output:
Case 1: 9
Case 2: 10
 */

import java.util.Scanner;

public class FaridaMaxGoldCoins {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            FaridaMaxGoldCoins obj = new FaridaMaxGoldCoins();
            System.out.println("Case #" + (t + 1) + ": " + obj.maxGoldCoins(arr));
        }
    }

    public long maxGoldCoins(int[] arr) {
        int len = arr.length;
        if(len == 0) return 0;
        if(len == 1) return arr[0];
        if(len == 2) return Math.max(arr[0], arr[1]);
        long[] dp = new long[len + 1];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }

        return dp[len - 1];
    }
}
