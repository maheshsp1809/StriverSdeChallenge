package July12;

import java.util.ArrayList;
import java.util.List;

public class BPrintLis {
    public static int findInsertionPoint(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int insertionPoint = list.size();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                insertionPoint = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return insertionPoint;
    }

    public static int longestIncreasingSubsequence(int[] arr, int n) {
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        int length = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > lis.get(length - 1)) {
                lis.add(arr[i]);
                length++;
            } else {
                int insertionPoint = findInsertionPoint(lis, arr[i]);
                lis.set(insertionPoint, arr[i]);
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " +
                longestIncreasingSubsequence(arr, n));
    }
}
