package June21;

public class Maze {
    public static void main(String[] args) {
        int[][] array = new int[3][3];
        traverseMaze(array);

    }

    public static void traverseMaze(int[][] maze) {
        int row = 3;
        int col = 3;
        int[] count = new int[] { 0 };
        int k = h(maze, "", row, col);
        System.out.println(count[0]);
        System.out.println(k);
    }

    public static int h(int[][] maze, String path, int row, int col) {
        if (row == 0 && col == 0) {
            System.out.println(path);
            return 1;
        }

        int l = h(maze, path + "R", row - 1, col);
        int r = h(maze, path + "C", row, col - 1);
        return l + r;
    }

}
