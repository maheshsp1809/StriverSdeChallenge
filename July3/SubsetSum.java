package July3;

import java.util.Arrays;

public class SubsetSum {
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < arr[i - 1]) {
                    // If current element is greater than the sum required, exclude it
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Include current element and check if sum can be achieved
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        // Print the final DP table
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        int[] arr = { 6, 1, 2, 1 };
        int n = arr.length;
        int k = 4;

        boolean isSubsetSum = subsetSumToK(n, k, arr);
        System.out.println("Is there a subset with sum " + k + "? " + isSubsetSum);
    }
}
