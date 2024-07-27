class Solution {
    static int countMin(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        // Fill the table for subsequences of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of the longest palindromic subsequence
        int lps = dp[0][n - 1];

        // Minimum insertions required
        return n - lps;
    }
}
