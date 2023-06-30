package June30;

import java.util.Arrays;

public class Knapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int ind = 0; ind < n; ++ind)
            dp[ind][0] = 0;
        for (int w = 0; w <= maxWeight; ++w)
            dp[0][w] = value[0];
        for (int ind = 1; ind < n; ++ind) {
            for (int w = 0; w <= maxWeight; ++w) {
                int nottake = dp[ind - 1][w];
                int take = 0;
                if (weight[ind] <= w)
                    take = value[ind] + dp[ind - 1][w - weight[ind]];
                dp[ind][w] = Math.max(take, nottake);
            }
        }

        // Print the final DP table
        System.out.println("Final DP Table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n-1][maxWeight];
        // return h(n-1, maxWeight, weight, value,dp);
    }

    public static void main(String[] args) {
        int[] weight = { 1, 2, 4, 5 };
        int[] value = { 5, 4, 8, 6 };
        int n = weight.length;
        int maxWeight = 5;

        int maxProfit = knapsack(weight, value, n, maxWeight);
        System.out.println("Max Profit: " + maxProfit);
    }
}
