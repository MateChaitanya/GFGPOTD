class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        if (n == 0 || m == 0) return 0;

        int[][] dp = new int[n][m];
        int maxSize = 0;

        // Initialize the first row and first column of dp array
        for (int i = 0; i < n; i++) {
            dp[i][0] = mat[i][0];
            maxSize = Math.max(maxSize, dp[i][0]);
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
            maxSize = Math.max(maxSize, dp[0][j]);
        }

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxSize = Math.max(maxSize, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxSize;
    }
}
