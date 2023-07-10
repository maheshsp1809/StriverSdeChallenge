package July10;

import java.util.*;

public class StockBuy2 {
    public static long getMaximumProfit(int n, long[] values, long[][] dp) {
        return rec(values, 0, 1, dp);
    }

    public static long rec(long[] values, int ind, int buy, long[][] dp) {
        if (ind == values.length)
            return 0;
        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        if (buy == 1) {
            long buys = -values[ind] + rec(values, ind + 1, 0, dp);
            long nobuy = rec(values, ind + 1, 1, dp);
            return dp[ind][buy] = Math.max(buys, nobuy);
        } else {
            long sell = values[ind] + rec(values, ind + 1, 1, dp);
            long dontsell = rec(values, ind + 1, 0, dp);
            return dp[ind][buy] = Math.max(sell, dontsell);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        long[] values = { 7, 1, 5, 3, 6, 4 };

        long[][] dp = new long[n][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        long maximumProfit = getMaximumProfit(n, values, dp);
        System.out.println("Maximum Profit: " + maximumProfit);

        System.out.println("Final DP Table:");
        for (long[] row : dp) {
            for (long value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
