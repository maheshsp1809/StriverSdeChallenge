package June29Dp;

public class SubsetSumDp {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        Boolean[][] memo = new Boolean[n + 1][k + 1];
        return subsetSumToKHelper(n, k, arr, memo);
    }

    public static boolean subsetSumToKHelper(int n, int k, int arr[], Boolean[][] memo) {
        if (k == 0)
            return true;
        if (n == 0 || k < 0)
            return false;
        if (memo[n][k] != null)
            return memo[n][k];

        boolean include = subsetSumToKHelper(n - 1, k - arr[n - 1], arr, memo);
        boolean exclude = subsetSumToKHelper(n - 1, k, arr, memo);

        memo[n][k] = include || exclude;

        return memo[n][k];
    }

    public static void printDPMatrix(Boolean[][] dp) {
        int rows = dp.length;
        int cols = dp[0].length;

        System.out.println("DP Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 6, 5 }; // Example array
        int sum = 5; // Example target sum
        int n = arr.length;

        Boolean[][] memo = new Boolean[n][sum + 1];
        boolean result = subsetSumToKHelper(n - 1, sum, arr, memo);

        System.out.println("Subset with sum " + sum + " exists: " + result);
        printDPMatrix(memo);
    }
}
