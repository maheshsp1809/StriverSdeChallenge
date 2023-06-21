package June21;

import java.util.*;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        int uniquePaths = uniquePaths(m, n);
        System.out.println("Number of unique paths: " + uniquePaths);
    }

    public static int uniquePaths(int m, int n) {
        int[][] count = new int[m + 1][n + 1];
        for (int[] row : count) {
            Arrays.fill(row, -1);
        }
        return h(m - 1, n - 1, count);
    }

    public static int h(int m, int n, int[][] count) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (count[m][n] != -1) {
            return count[m][n];
        }
        int down = h(m - 1, n, count);
        int right = h(m, n - 1, count);
        count[m][n] = down + right;
        return count[m][n];
    }
}
