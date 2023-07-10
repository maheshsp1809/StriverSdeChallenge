package June30;

import java.util.*;

public class FindWays {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        return h(n - 1, tar, num);
    }

    public static int h(int n, int tar, int num[]) {
        if (tar == 0)
            return 1;
        if (n == 0 || tar < 0)
            return 0;
        int take = h(n - 1, tar - num[n - 1], num);
        int notake = h(n - 1, tar, num);
        return take + notake;
    }

    public static void main(String[] args) {
        int[] num = { 2, 4, 6 };
        int target = 6;
        int ways = findWays(num, target);
        System.out.println("Number of ways to achieve the target: " + ways);
    }
}
