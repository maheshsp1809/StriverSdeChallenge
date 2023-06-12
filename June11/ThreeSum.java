package June11;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum > K) {
                    --k;
                } else if (sum < K) {
                    ++j;
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k])));

                    while (j < k && arr[j] == arr[j + 1])
                        ++j;
                    while (j < k && arr[k] == arr[k - 1])
                        --k;
                    ++j;
                    --k;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 25, -60, 2, 4, 5, 13, 15, 25, 26 };
        int n = arr.length;
        int K = 30;

        ArrayList<ArrayList<Integer>> triplets = findTriplets(arr, n, K);

        if (triplets.isEmpty()) {
            System.out.println("No triplets found with the sum " + K);
        } else {
            System.out.println("Triplets with the sum " + K + ":");
            for (ArrayList<Integer> triplet : triplets) {
                System.out.println(triplet);
            }
        }
    }
}
