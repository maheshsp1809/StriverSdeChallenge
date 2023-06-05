package June5;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class MissingDuplicate {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int res[] = new int[2];
        Arrays.fill(res, 0);
        for (int i = 1; i <= n; ++i) {
            if (arr.contains(i)) {
                arr.remove(arr.indexOf(i));
            } else {
                res[0] = i;
            }
        }

        res[1] = arr.get(0);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        ArrayList<Integer> missing = new ArrayList<Integer>();
        System.out.println("add elements to the array list");
        for (int i = 0; i < n; ++i) {
            missing.add(i, scanner.nextInt());
        }
        int[] res = missingAndRepeating(missing, n);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
