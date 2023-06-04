import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int u = 0;
        int d = n - 1;
        int l = 0;
        int r = m - 1;

        while (l < r && u < d) {
            int prev = mat.get(u + 1).get(l);

            for (int i = l; i <= r; i++) {
                int curr = mat.get(u).get(i);
                mat.get(u).set(i, prev);
                prev = curr;
            }

            u++;

            for (int i = u; i <= d; i++) {
                int curr = mat.get(i).get(r);
                mat.get(i).set(r, prev);
                prev = curr;
            }

            r--;

            for (int i = r; i >= l; i--) {
                int curr = mat.get(d).get(i);
                mat.get(d).set(i, prev);
                prev = curr;
            }

            d--;

            for (int i = d; i >= u; i--) {
                int curr = mat.get(i).get(l);
                mat.get(i).set(l, prev);
                prev = curr;
            }

            l++;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(7, 8, 9));
        mat.add(row1);
        mat.add(row2);
        mat.add(row3);

        int n = mat.size();
        int m = mat.get(0).size();

        rotateMatrix(mat, n, m);

        for (ArrayList<Integer> row : mat) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
