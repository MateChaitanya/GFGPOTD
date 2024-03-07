class Solution {
    public String longestSubstring(String s, int n) {
        // code here
        int[][] dp = new int[n + 1][n + 1];
        int res_length = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (j - i > dp[i - 1][j - 1] && s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > res_length) {
                        res_length = dp[i][j];
                        index = Math.max(i, index);
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        if (res_length > 0) {
            for (int i = index - res_length + 1; i <= index; i++) {
                res.append(s.charAt(i - 1));
            }
        }
        if (res.length() == 0) {
            res.append("-1");
        }
        return res.toString();
    }
}
