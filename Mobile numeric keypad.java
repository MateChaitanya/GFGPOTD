class Solution {
    public long getCount(int n) {
        // Keypad layout and valid moves
        int[][] moves = {
            {0, 8},       // from 0
            {1, 2, 4},    // from 1
            {2, 1, 3, 5}, // from 2
            {3, 2, 6},    // from 3
            {4, 1, 5, 7}, // from 4
            {5, 2, 4, 6, 8}, // from 5
            {6, 3, 5, 9}, // from 6
            {7, 4, 8},    // from 7
            {8, 0, 5, 7, 9}, // from 8
            {9, 6, 8}     // from 9
        };
        
        // If n is 1, return 10 (0-9 are all valid sequences)
        if (n == 1) {
            return 10;
        }
        
        // DP array initialization
        long[][] dp = new long[n + 1][10];
        
        // Base case: for sequences of length 1, we have 1 way to end at each digit
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        
        // Fill the DP table
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i][j] = 0;
                for (int move : moves[j]) {
                    dp[i][j] += dp[i - 1][move];
                }
            }
        }
        
        // Sum up all the ways to form sequences of length n ending at any digit
        long totalCount = 0;
        for (int i = 0; i <= 9; i++) {
            totalCount += dp[n][i];
        }
        
        return totalCount;
    }
}
