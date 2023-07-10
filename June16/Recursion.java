package June16;

import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {
        // int n = 6;
        // int ans = fib(n);
        // System.out.println(ans);
        // System.out.println(reverse(123456));
        // int[] arr = new int[] { 6, 5, 4, 3, 2, 1 };
        // itBubble(arr);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // pattern(4, 0);
        int[] arr = new int[] { 6, 5, 4, 3, 2, 1 };
        // itSelect(arr);
        // reBubble(arr, 5, 0);
        reSelect(arr, 5, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static int fib(int n) {
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; ++i) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }

    public static int reverse(int n) {
        int size = size(n);
        System.out.println(size);
        int ans = 0;
        // return reverseHelper(n, size - 1, ans);
        return reverseHelper1(n, ans);
    }

    public static int size(int n) {
        if (n == 0)
            return 0;
        return 1 + size(n / 10);
    }

    public static int reverseHelper(int n, int size, int ans) {
        if (size == 0) {
            ans += n;
            return ans;
        }

        ans += (n % 10) * ((int) Math.pow(10, size));
        return reverseHelper(n / 10, size - 1, ans);

    }

    public static int reverseHelper1(int n, int ans) {
        if (n == 0)
            return ans;
        ans = ans * 10 + (n % 10);
        return reverseHelper1(n / 10, ans);
    }

    public static void itBubble(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void pattern(int row, int col) {
        if (row == 1)
            return;
        if (col < row) {
            pattern(row, col + 1);
            System.out.print("*" + " ");
        } else {
            pattern(row - 1, 0);
            System.out.println();

        }

    }

    public static void reBubble(int[] arr, int row, int col) {
        if (row == 0)
            return;
        if (col < row) {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            reBubble(arr, row, col + 1);

        } else {
            reBubble(arr, row - 1, 0);

        }
    }

    public static void itSelect(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void reSelect(int[] arr, int row, int col, int min) {
        if (row == 0)
            return;
        if (col < row) {
            if (arr[min] < arr[col]) {
                reSelect(arr, row, col + 1, col);
            } else {
                reSelect(arr, row, col + 1, min);
            }
        } else {
            int temp = arr[min];
            arr[min] = arr[row - 1];
            arr[row - 1] = temp;
            reSelect(arr, row - 1, 0, 0);
        }
    }

}
