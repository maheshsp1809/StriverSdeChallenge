package June5;

import java.io.*;
import java.util.*;

public class MergeTwoSorted {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int i = m - n - 1;
        int j = n - 1;
        int k = m - 1;
        while (j >= 0) {
            if (i >= 0 && arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the first array:");
        int m = scanner.nextInt();
        int[] arr1 = new int[m];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < m; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.println("Enter the size of the second array:");
        int n = scanner.nextInt();
        int[] arr2 = new int[n];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] result = ninjaAndSortedArrays(arr1, arr2, m, n);
        System.out.println("Merged Array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
