package June8;

import java.io.*;
import java.util.*;

public class Majority1 {
    public static int findMajority(int[] arr, int n) {
        int maj = 0;
        int c = 0;
        for (int num : arr) {
            if (c == 0) {
                maj = num;
                c = 1;
            } else if (maj == num) {
                ++c;
            } else {
                --c;
            }
        }
        int c1 = 0;
        for (int i = 0; i < n; ++i) {
            if (maj == arr[i])
                ++c1;
        }
        return (c1 > (n / 2)) ? maj : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The majority element is: " + findMajority(arr, n));

    }
}
