package June11;

import java.util.Scanner;

public class CountInversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int count = countInversions(arr);
        System.out.println(count);

    }

    public static int countInversions(int arr[]) {
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int[] temp, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count += mergeSort(arr, temp, start, mid);
            count += mergeSort(arr, temp, mid + 1, end);
            count += merge(arr, temp, start, mid, end);
        }
        return count;
    }

    public static int merge(int[] arr, int[] temp, int start, int mid, int end) {
        int count = 0;
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                count += mid - i + 1;
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (int l = start; l <= end; l++) {
            arr[l] = temp[l];
        }

        return count;
    }

}
