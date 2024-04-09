class Solution {
    public int minPoints(int points[][], int m, int n) {
        int[][] dp = new int[m][n];
        
        // Fill the dp array starting from the bottom-right corner
        dp[m-1][n-1] = Math.max(1, 1 - points[m-1][n-1]);
        
        // Fill the last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - points[i][n-1]);
        }
        
        // Fill the last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - points[m-1][j]);
        }
        
        // Fill the rest of the dp array bottom-up
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minPointsNeeded = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, minPointsNeeded - points[i][j]);
            }
        }
        
        return dp[0][0];
    }
}
