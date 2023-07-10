package July5;

import java.util.Arrays;

public class Lcs {
    public static void main(String[] args) {
        String s = "ABCD";
        String t = "BCACDHB";
        int lcsValue = lcs(s, t);
        System.out.println("Longest Common Subsequence: " + lcsValue);
    }

    public static int lcs(String s, String t) {
        return ht(s, t);
    }

    public static int ht(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (t.charAt(0) == s.charAt(i))
                dp[i][0] = 1;
        }
        for (int i = 0; i < t.length(); ++i) {
            if (s.charAt(0) == t.charAt(i))
                dp[0][i] = 1;
        }
        for (int i = 1; i < s.length(); ++i) {
            for (int j = 1; j < t.length(); ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s.charAt(i) == t.charAt(j))
                    dp[i][j] += 1;
            }
        }
        int lcsValue = dp[s.length() - 1][t.length() - 1];
        System.out.println("DP Table:");
        printTable(dp);
        return lcsValue;
    }

    public static void printTable(int[][] table) {
        for (int[] row : table) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
