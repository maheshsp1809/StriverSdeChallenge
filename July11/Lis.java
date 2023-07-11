package July11;

import java.util.Arrays;

public class Lis {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 11, 1, 16, 8 };
        int longestLength = longestIncreasingSubsequence(arr);
        System.out.println("Longest Increasing Subsequence Length: " + longestLength);
    }

    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int longestLength = rec(arr, 0, -1, dp);
        printDPTable(dp);
        return longestLength;
    }

    public static int rec(int[] arr, int ind, int prev_index, int[][] dp) {
        if (ind == arr.length)
            return 0;
        if (dp[ind][prev_index + 1] != -1)
            return dp[ind][prev_index + 1];
        int take = 0;
        if (prev_index == -1 || arr[ind] > arr[prev_index])
            take = 1 + rec(arr, ind + 1, ind, dp);
        int nottake = rec(arr, ind + 1, prev_index, dp);
        return dp[ind][prev_index + 1] = Math.max(take, nottake);
    }

    public static void printDPTable(int[][] dp) {
        System.out.println("DP Table:");
        for (int[] row : dp) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
