class Solution
{
    int MOD = 1000000007;

    int subsequenceCount(String s, String t)
    {
        int n = s.length();
        int m = t.length();

        // Initialize a 2D array to store the count of distinct occurrences
        int[][] dp = new int[m + 1][n + 1];

        // Initialize dp[0][j] to 1, because an empty string is always a subsequence of any string
        for (int j = 0; j <= n; j++)
            dp[0][j] = 1;

        // Iterate through each character of t
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, we have two options:
                // 1. Exclude the current character of s and consider the count till the previous character.
                // 2. Include the current character of s and move to the next character in both s and t.
                if (t.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i][j - 1]) % MOD;
                // If the characters don't match, exclude the current character of s.
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        // The result will be stored at dp[m][n]
        return dp[m][n];
    }
}
