package June28Dp;

import java.util.Arrays;

public class NinjaTrain {
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return hm(n - 1, 3, points, dp);
    }

    public static int hm(int n, int last, int[][] points, int[][] dp) {
        if (n == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; ++i) {
                if (i != last) {
                    maxi = Math.max(points[n][i], maxi);
                }
            }
            return dp[n][last] = maxi;
        }
        if (dp[n][last] != -1)
            return dp[n][last];
        int max = 0;
        for (int task = 0; task < 3; ++task) {
            if (task != last) {
                int point = points[n][task] + hm(n - 1, task, points, dp);
                max = Math.max(max, point);
            }
        }
        return dp[n][last] = max;
    }

    public static int tableNinja(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[n - 1][3];

    }

    public static int space(int n, int[][] points) {
        int prev[] = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;

        }

        return prev[3];
    }

    public static void main(String[] args) {
        int[][] points = {
                { 3, 2, 7 },
                { 9, 1, 2 },
                { 1, 5, 4 },
                { 6, 8, 2 }
        };
        int n = points.length;

        // int maxPoints = ninjaTraining(n, points);
        // int maxTablur = tableNinja(n, points);
        int spaceOpti = space(n, points);
        // System.out.println("Maximum points memoisation: " + maxPoints);
        // System.out.println("Maximum points tabulation: " + maxTablur);
        System.out.println("Maximum points via space optimsiation:" + spaceOpti);

    }
}
