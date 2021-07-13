package ds.program.dp;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
In Byteland they have a very strange monetary system.

Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).

You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.

You have one gold coin. What is the maximum amount of American dollars you can get for it?

Input
The input will contain several test cases (not more than 10). Each testcase is a single line with a number n, 0 <= n <= 1 000 000 000. It is the number written on your coin.

Output
For each test case output a single line, containing the maximum amount of American dollars you can make.

Example
Input:
12
2

Output:
13
2
 */
public class CoinExchInto3CoinsRecurse {
    static int dp[];

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        initCoins(100000000);
        CoinExchInto3CoinsRecurse obj = new CoinExchInto3CoinsRecurse();
        while (sc.hasNext()) {
            String s = sc.next();
            long num = Long.parseLong(s);
            if (num > 100000000) {
                System.out.println(obj.findLongCoinExchange(num));
            } else {
                int nn = Integer.parseInt(s);


                System.out.println(obj.coinExchange(nn));
                //System.out.println(obj.dp[nn / 2] + " " + obj.dp[nn / 3] + " " + obj.dp[nn / 4]);
            }
        }
    }

    private static void initCoins(int n) {
        dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else {
                dp[i] = Math.max(i, dp[i / 4] + dp[i / 3] + dp[i / 2]);
            }
        }
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                if (dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private long findLongCoinExchange(long num) {
        if (num > 100000000) {
            return Math.max(num, findLongCoinExchange(num / 4)
                    + findLongCoinExchange(num / 3) + findLongCoinExchange(num / 2));
        } else {
            int res = coinExchange((int) num);
            return res;
        }
    }

    public int coinExchange(int n) {
        return dp[n];
    }
}
