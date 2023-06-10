package June10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermu {
    public static void main(String[] args) {
        // Test the nextPermutation method
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("Original List: " + list1);
        ArrayList<Integer> result1 = nextPermutation(list1);
        System.out.println("Next Permutation: " + result1);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println("Original List: " + list2);
        ArrayList<Integer> result2 = nextPermutation(list2);
        System.out.println("Next Permutation: " + result2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 1, 5));
        System.out.println("Original List: " + list3);
        ArrayList<Integer> result3 = nextPermutation(list3);
        System.out.println("Next Permutation: " + result3);
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> P) {
        int ind = -1;
        int n = P.size();
        for (int i = n - 2; i >= 0; i--) {
            if (P.get(i) < P.get(i + 1)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            Collections.reverse(P);
            return P;
        }

        for (int i = n - 1; i > ind; i--) {
            if (P.get(i) > P.get(ind)) {
                swap(P, i, ind);
                break;
            }
        }
        reverse(P, ind + 1, n - 1);
        return P;
    }

    private static void swap(ArrayList<Integer> P, int i, int j) {
        int temp = P.get(i);
        P.set(i, P.get(j));
        P.set(j, temp);
    }

    private static void reverse(ArrayList<Integer> P, int start, int end) {
        while (start < end) {
            swap(P, start, end);
            start++;
            end--;
        }
    }
}
