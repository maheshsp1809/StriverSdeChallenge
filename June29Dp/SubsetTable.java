package June29Dp;

import java.util.*;

class SubsetTable {

    static int subsetSumToK(int n, int k, int[] arr) {

        boolean dp[][] = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {

                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;
                if (arr[ind] <= target)
                    taken = dp[ind - 1][target - arr[ind]];

                dp[ind][target] = notTaken || taken;
            }
        }
        for (int i = n - 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(j + " " + dp[i][j] + " ");
            }
            System.out.println();
        }
        int totSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            totSum += arr[i];
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i] == true) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;

        // return dp[n - 1][k];
    }

    public static void main(String args[]) {

        int arr[] = { 8, 6, 5 };
        int k = 19;
        int n = arr.length;
        int ans = subsetSumToK(n, k, arr);
        if (ans != 0)
            System.out.println("Subset with given target found  " + ans);
        else
            System.out.println("Subset with given target not found");
    }
}
