package June22;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(1);
        arr.add(2);
        arr.add(7);
        arr.add(6);
        arr.add(1);
        arr.add(5);

        int target = 8;

        ArrayList<ArrayList<Integer>> result = combinationSum2(arr, arr.size(), target);

        // Print the result
        for (ArrayList<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(arr);
        h(arr, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void h(ArrayList<Integer> arr, int ind, int target, ArrayList<Integer> curr,
            ArrayList<ArrayList<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = ind; i < arr.size(); ++i) {
            if (i > ind && arr.get(i).equals(arr.get(i - 1)))
                continue;
            curr.add(arr.get(i));
            h(arr, i + 1, target - arr.get(i), curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
