package June8;

import java.io.*;
import java.util.*;

public class LongestConsec {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int currentStreak = 1;

                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter number of elements for next testcase:");
            int N = sc.nextInt();
            int[] arr = new int[N];
            System.out.println("Enter elements ");
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(lengthOfLongestConsecutiveSequence(arr, N));
        }

    }

}
