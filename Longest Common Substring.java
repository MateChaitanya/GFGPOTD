class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        // Create a 2D array to store the lengths of common substrings
        int[][] dp = new int[n + 1][m + 1];
        int maxLength = 0;
        
        // Iterate through both strings
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match, update dp[i][j]
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0; // Reset if characters don't match
                }
            }
        }
        
        return maxLength;
    }
}
