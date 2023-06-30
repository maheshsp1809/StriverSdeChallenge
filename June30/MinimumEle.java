package June30;

import java.util.*;

public class MinimumEle {
    public static int minimumElements(int num[], int t) {
        int[][] dp = new int[num.length][t + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = h(num, num.length - 1, t, dp);
        if (ans == (int) Math.pow(10, 9))
            ans = -1;
        System.out.println("DP table:");
        for (int[] row : dp) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        return ans;
    }

    public static int h(int[] num, int ind, int t, int[][] dp) {
        if (ind == 0) {
            if (t % num[0] == 0)
                return t / num[0];
            else
                return (int) Math.pow(10, 9);
        }
        if (dp[ind][t] != -1)
            return dp[ind][t];
        int take = (int) Math.pow(10, 9);
        if (t >= num[ind])
            take = 1 + h(num, ind, t - num[ind], dp);
        int nonTake = h(num, ind - 1, t, dp);
        return dp[ind][t] = Math.min(take, nonTake);
    }

    public static void main(String[] args) {
        int[] num = { 1, 2, 3 };
        int t = 7;

        int result = minimumElements(num, t);
        System.out.println("Minimum elements required: " + result);

        // Print the final DP table

    }
}
