class Solution {
    private long[][][] dp;

    private long helper(int n, int m, int k, int[][] arr) {
        if (k < 0)
            return 0;
        if (m < 0 || n < 0)
            return 0;
        if (n == 0 && m == 0)
            return dp[n][m][k] = (k == arr[n][m] ? 1 : 0);
        if (dp[n][m][k] != -1)
            return dp[n][m][k];
        long left = (m > 0) ? helper(n, m - 1, k - arr[n][m], arr) : 0;
        long up = (n > 0) ? helper(n - 1, m, k - arr[n][m], arr) : 0;
        return dp[n][m][k] = (left + up) % 1000000007; // Taking modulo to avoid overflow
    }

    public long numberOfPath(int n, int k, int[][] arr) {
        dp = new long[n][n][k + 1]; // Initialize dp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1); // Initialize with -1
            }
        }
        return helper(n - 1, n - 1, k, arr);
    }
}
