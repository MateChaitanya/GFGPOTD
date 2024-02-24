class Solution {
    public int maxSum(int n) 
    { 
        if (n <= 0) return 0;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(i, dp[i/2] + dp[i/3] + dp[i/4]);
        }
        
        return dp[n];
    } 
}
