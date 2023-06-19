package June19;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    public static void main(String[] args) {
        int[] num = { 1, 2, 3 };
        ArrayList<Integer> result = subsetSum(num);
        System.out.println(result);
    }

    public static ArrayList<Integer> subsetSum(int[] num) {
        ArrayList<Integer> ans = new ArrayList<>();
        h(num, 0, 0, ans);
        Collections.sort(ans);
        return ans;
    }

    public static void h(int[] num, int ind, int s, ArrayList<Integer> ans) {
        if (ind == num.length) {
            ans.add(s);
            return;
        }

        h(num, ind + 1, s + num[ind], ans);
        h(num, ind + 1, s, ans);
    }
}
