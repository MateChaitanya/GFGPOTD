class Solution {
    public int ways(int x, int y) {
        int mod = 1000000007; // 1e9+7 in the C++ code
        int[][] dp = new int[x+1][y+1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                // Base case initialization
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // State transition
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
                }
            }
        }
        
        return dp[x][y];
    }
}
