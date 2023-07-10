package June30;

import java.util.ArrayList;
import java.util.Arrays;

public class GridUnique {
    public static int uniquePathsWithObstacles(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        // int result = helper(nums, m - 1, n - 1, dp);
        // printDPTable(dp);

        // return result;
        int[] prev = new int[n];
        Arrays.fill(prev, 0);

        return spacemore(nums, m, n, prev);
    }

    public static int helper(int[][] nums, int m, int n, int[][] dp) {
        for (int i = 0; i <= n; ++i) {
            if (nums[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 0; i <= m; ++i) {
            if (nums[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (nums[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                int l = dp[i - 1][j];
                int r = dp[i][j - 1];
                dp[i][j] = l + r;
            }
        }

        return dp[m][n];
    }

    public static void printDPTable(int[][] dp) {
        System.out.println("DP Table:");
        for (int[] row : dp) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int spacemore(int[][] nums, int m, int n, int[] prev) {
        prev[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) {
                    prev[j] = 0;
                } else if (j > 0) {
                    prev[j] = (prev[j] + prev[j - 1]);
                }
            }
            for (int k : prev)
                System.out.print(k + ",");
            System.out.println();

        }

        return prev[n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        int uniquePaths = uniquePathsWithObstacles(nums);
        System.out.println("Number of unique paths: " + uniquePaths);
    }
}
