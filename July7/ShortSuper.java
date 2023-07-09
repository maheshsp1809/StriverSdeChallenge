package July7;

import java.util.*;
import java.io.*;

public class ShortSuper {
    public static void main(String[] args) {
        String s = "blue";
        String t = "bleed";
        String result = shortestSupersequence(s, t);
        System.out.println("Shortest Supersequence: " + result);
    }

    public static String shortestSupersequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        return ht(s, t, dp);
    }

    public static String ht(String s, String t, int[][] dp) {
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= t.length(); ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = s.length();
        int j = t.length();
        String ans = "";
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans += s.charAt(i - 1);
                --i;
                --j;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += s.charAt(i - 1);
                --i;
            } else {
                ans += t.charAt(j - 1);
                --j;
            }
        }
        while (i > 0) {
            ans += s.charAt(i - 1);
            --i;
        }
        while (j > 0) {
            ans += t.charAt(j - 1);
            --j;
        }
        StringBuilder sb = new StringBuilder(ans);
        return sb.reverse().toString();
    }
}
