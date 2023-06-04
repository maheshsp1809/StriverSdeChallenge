import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> res = new ArrayList<>();
        ArrayList<Long> row, prev = null;
        for (int i = 0; i < n; ++i) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1L);
                } else {
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = row;
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        ArrayList<ArrayList<Long>> pascalTriangle = printPascal(n + 1);

        for (ArrayList<Long> row : pascalTriangle) {
            for (Long num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
