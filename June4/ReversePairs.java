package June4;

import java.util.ArrayList;

public class ReversePairs {
    public static int reversePairs(ArrayList<Integer> arr) {
        return mergeSort(arr, 0, arr.size() - 1);
    }

    public static int mergeSort(ArrayList<Integer> arr, int start, int end) {
        int invCount = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            invCount += mergeSort(arr, start, mid);
            invCount += mergeSort(arr, mid + 1, end);
            invCount += merge(arr, start, mid, end);
        }
        return invCount;
    }

    public static int merge(ArrayList<Integer> arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;
        int invCount = 0;

        while (i <= mid && j <= end) {
            if ((long) arr.get(i) > 2L * arr.get(j)) {
                invCount += mid - i + 1; // Count the reverse pairs
                j++;
            } else {
                i++;
            }
        }

        i = start;
        j = mid + 1;

        ArrayList<Integer> temp = new ArrayList<>();

        while (i <= mid && j <= end) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i++));
            } else {
                temp.add(arr.get(j++));
            }
        }

        while (i <= mid) {
            temp.add(arr.get(i++));
        }

        while (j <= end) {
            temp.add(arr.get(j++));
        }

        for (int l = start; l <= end; l++) {
            arr.set(l, temp.get(l - start));
        }

        return invCount;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(3);
        arr.add(1);

        int result = reversePairs(arr);
        System.out.println("Number of reverse pairs: " + result);
    }
}
