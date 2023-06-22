package June22;

import java.util.ArrayList;

public class SubsetSumtoK {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        int target = 7;

        ArrayList<ArrayList<Integer>> result = findSubsetsThatSumToK(arr, arr.size(), target);

        // Print the result
        for (ArrayList<Integer> subset : result) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        h(arr, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void h(ArrayList<Integer> arr, int ind, int target, ArrayList<Integer> curr,
            ArrayList<ArrayList<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
        }
        if (ind == arr.size())
            return;
        for (int i = ind; i < arr.size(); ++i) {
            curr.add(arr.get(i));
            h(arr, i + 1, target - arr.get(i), curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
