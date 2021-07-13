package ds.program.dp;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.maxProfit(lengths, prices, 5);
        System.out.print(maxProfit);
    }

    private int maxProfit(int[] length, int[] price, int maxLength) {
        if (maxLength <= 0 || length.length != price.length || price.length == 0) return 0;
        int lengthCount = length.length;
        int[][] dp = new int[lengthCount][maxLength + 1];
        for (int i = 0; i < lengthCount; i++) {
            for (int len = 1; len <= maxLength; len++) {
                int profit1 = 0, profit2 = 0;
                if (length[i] <= len) {
                    profit1 = price[i] + dp[i][len - length[i]];
                }
                if (i > 0)
                    profit2 = dp[i - 1][len];
                dp[i][len] = Math.max(profit1, profit2);
            }
        }
        printSelectedElements(dp, length, price, maxLength);
        return dp[lengthCount - 1][maxLength];
    }

    private void printSelectedElements(int[][] dp, int[] lengths, int[] profits, int capacity) {
        int row = lengths.length - 1;
        int totalProfit = dp[row][capacity];
        if (totalProfit == profits[row - 1]) {
            System.out.println(lengths[row - 1]);
            return;
        }
        while (totalProfit != 0) {
            if (row >= 1 && dp[row][capacity] != dp[row - 1][capacity]) {
                capacity -= row + 1;
                totalProfit -= profits[row];
                System.out.print(lengths[row]+ " ");
            } else if (row >= 1) {
                row--;
            } else {
                System.out.println(capacity);
                break;
            }
        }
    }
}