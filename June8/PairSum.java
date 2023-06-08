package June8;

import java.util.*;

public class Solution {
    public static List<int[]> pairSum(int[] arr, int s) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        List<int[]> ans = new ArrayList<>();

        while (i < arr.length) {
            if (j == i) {
                j = arr.length - 1;
                i++;
            }
            if (arr[i] + arr[j] == s) {
                int[] temp = { arr[i], arr[j] };
                ans.add(temp);

                if (j == i) {
                    j = arr.length - 1;
                    i++;
                }
                j--;
            } else {
                if (j == i) {
                    j = arr.length - 1;
                    i++;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }
}
