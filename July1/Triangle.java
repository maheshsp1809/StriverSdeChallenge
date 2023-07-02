package July1;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = {
                { 2 },
                { 3, 4 },
                { 6, 5, 7 },
                { 4, 1, 8, 3 }
        };
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, 0);
        int min = (int) 1e9;
        // for (int i = 0; i < n; ++i) {
        // min = Math.min(min, rec(triangle, i, n - 1, dp));
        // printDPTable(dp);
        // }
        min = ht(triangle, n - 1, dp);
        System.out.println("Minimum path sum: " + (min == (int) 1e9 ? -1 : min));
        min = minimumPathSum(triangle, min);
        System.out.println("Minimum path sum: " + (min == (int) 1e9 ? -1 : min));
    }

    public static int rec(int[][] triangle, int ind, int n, int[][] dp) {
        if (n < 0 || ind < 0 || ind > n)
            return (int) 1e9;
        if (ind == 0 && n == 0)
            return triangle[0][0];
        if (dp[n][ind] != -1)
            return dp[n][ind];
        int up = triangle[n][ind] + rec(triangle, ind, n - 1, dp);
        int left = triangle[n][ind] + rec(triangle, ind - 1, n - 1, dp);
        dp[n][ind] = Math.min(up, left);

        return dp[n][ind];
    }

    public static int ht(int[][] triangle, int n, int[][] dp) {
        dp[0][0] = triangle[0][0];

        // Iterate from the second row up to the last row
        for (int i = 1; i < n; i++) {
            // Calculate the minimum path sum for the first position in the row
            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            // Calculate the minimum path sum for the positions in the middle of the row
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }

            // Calculate the minimum path sum for the last position in the row
            dp[i][i] = triangle[i][i] + dp[i - 1][i - 1];
        }

        int minPathSum = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][i]);
        }
        printDPTable(dp);
        return minPathSum;
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        // Create a 2D array to store the minimum path sums
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        // Initialize the first row of dp with the values from the triangle
        dp[0][0] = triangle[0][0];

        // Iterate from the second row up to the last row
        for (int i = 1; i < n; i++) {
            // Calculate the minimum path sum for the first position in the row
            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            // Calculate the minimum path sum for the positions in the middle of the row
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }

            // Calculate the minimum path sum for the last position in the row
            dp[i][i] = triangle[i][i] + dp[i - 1][i - 1];
        }

        // Find the minimum path sum in the last row of dp
        int minPathSum = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][i]);
        }

        return minPathSum;
    }

    public static void printDPTable(int[][] dp) {
        System.out.println("DP Table:");
        for (int[] row : dp) {
            for (int num : row) {
                if (num == -1)
                    System.out.print("- ");
                else
                    System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
