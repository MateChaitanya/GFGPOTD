class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        int[][] dp = new int[n + 1][w + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case: buying 0 kg of oranges costs 0
        dp[0][0] = 0;

        // Build up the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                // If the current packet size is unavailable, we can't use it
                if (cost[i - 1] == -1) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // If the current packet size is less than or equal to j,
                    // we have two options: either use the current packet or skip it
                    if (i <= j && dp[i][j - i] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i] + cost[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        // Check if it's possible to buy exactly w kg of oranges
        return dp[n][w] == Integer.MAX_VALUE ? -1 : dp[n][w];
    }
}
