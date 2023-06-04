import java.util.*;
import java.io.*;

public class MaxSubSum {
    public static long maxSubarraySum(int[] arr, int n) {
        if (n == 0)
            return 0;
        int curSum = arr[0];
        int sumTillnow = arr[0];
        for (int i = 1; i < n; ++i) {
            curSum = Math.max(arr[i], curSum + arr[i]);
            sumTillnow = Math.max(curSum, sumTillnow);
        }
        return sumTillnow < 0 ? 0 : sumTillnow;

    }

    public static void main(String[] args) {
        int arr[] = new int[] { 20, -30, 40, -60, 100 };
        int n = arr.length;
        System.out.println(maxSubarraySum(arr, n));
    }

}
