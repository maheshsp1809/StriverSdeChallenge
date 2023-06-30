package June30;

import java.util.Arrays;

public class KnapsackSpace {
    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] dp = new int[maxWeight + 1];

        Arrays.fill(dp, 0);

        for (int w = 0; w <= maxWeight; ++w) {
            if (weight[0] <= w)
                dp[w] = value[0];
        }
        for (int ind = 1; ind < n; ++ind) {
            int[] curr = new int[maxWeight + 1];
            for (int w = 0; w <= maxWeight; ++w) {
                int nottake = dp[w];
                int take = 0;
                if (weight[ind] <= w)
                    take = value[ind] + dp[w - weight[ind]];
                curr[w] = Math.max(take, nottake);
            }
            dp = curr;
        }
        // for (int ind = 1; ind < n; ++ind) {

        // for (int w = 0; w <= maxWeight; ++w) {
        // int nottake = dp[w];
        // int take = 0;
        // if (weight[ind] <= w)
        // take = value[ind] + dp[w - weight[ind]];
        // dp[w] = Math.max(take, nottake);
        // }

        // }

        // Print DP Table
        System.out.println("DP Table:");
        for (int w = 0; w <= maxWeight; ++w) {
            System.out.print(dp[w] + " ");
        }
        System.out.println();

        return dp[maxWeight];
    }

    public static void main(String[] args) {
        int[] weight = { 1, 5, 6, 9, 7, 9, 7 };
        int[] value = { 1, 7, 1, 5, 1, 7, 7 };
        int n = weight.length;
        int maxWeight = 37;

        int maxProfit = knapsack(weight, value, n, maxWeight);
        System.out.println("Maximum profit: " + maxProfit);
    }
}
