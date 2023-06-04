import java.io.*;
import java.util.*;

public class SetZeros {
    public static void setZeros(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row[] = new int[n];
        int col[] = new int[m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (row[i] == 1) {
                setRow(matrix, i);
            }
        }
        for (int i = 0; i < m; ++i) {
            if (col[i] == 1) {
                setCol(matrix, i);
            }
        }

    }

    public static void setRow(int matrix[][], int row) {
        for (int i = 0; i < matrix[0].length; ++i) {
            matrix[row][i] = 0;
        }
    }

    public static void setCol(int matrix[][], int col) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZeros(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}