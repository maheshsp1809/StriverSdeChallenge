package June19;

import java.util.ArrayList;

public class Subset2 {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        h(arr, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void h(int[] arr, int ind, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr) {
        ans.add(new ArrayList<>(curr));
        for (int i = ind; i < arr.length; ++i) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;
            curr.add(arr[i]);
            h(arr, i + 1, ans, curr); // Corrected the index parameter to i + 1
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        int n = arr.length;
        ArrayList<ArrayList<Integer>> subsets = uniqueSubsets(n, arr);

        // Print the subsets
        for (ArrayList<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
