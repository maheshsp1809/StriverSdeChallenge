package July10;

import java.util.*;

public class Stockbuy3 {
    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>(Arrays.asList(3, 3, 5, 0, 0, 3, 1, 4));
        int n = prices.size();

        int[][][] dp = new int[n][2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int maxProfit = maxProfit(prices, n, dp);
        System.out.println("Maximum Profit: " + maxProfit);

        System.out.println("\nDP Table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(dp[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int maxProfit(ArrayList<Integer> prices, int n, int[][][] dp) {
        return rec(prices, 0, 1, 1, dp);
    }

    public static int rec(ArrayList<Integer> values, int ind, int buy, int cap, int[][][] dp) {
        if (ind == values.size() || cap < 0)
            return 0;
        int profit = 0;
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        if (buy == 1) {
            int buys = -values.get(ind) + rec(values, ind + 1, 0, cap, dp);
            int nobuy = rec(values, ind + 1, 1, cap, dp);
            return dp[ind][buy][cap] = Math.max(buys, nobuy);
        } else {
            int sell = values.get(ind) + rec(values, ind + 1, 1, cap - 1, dp);
            int dontsell = rec(values, ind + 1, 0, cap, dp);
            return dp[ind][buy][cap] = Math.max(sell, dontsell);
        }
    }
}
