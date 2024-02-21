class Solution {
    int[][][] dp = new int[101][101][2];
    
    public Solution() {
        // Initialize the dp array with -1
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }
    
    private int solve(String s, int i, int j, int isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue == 1) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue] % 1003;
        }
        
        int ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int leftT, leftF, rightT, rightF;
            
            leftT = dp[i][k - 1][1] != -1 ? dp[i][k - 1][1] % 1003 : solve(s, i, k - 1, 1) % 1003;
            rightT = dp[k + 1][j][1] != -1 ? dp[k + 1][j][1] % 1003 : solve(s, k + 1, j, 1) % 1003;
            leftF = dp[i][k - 1][0] != -1 ? dp[i][k - 1][0] % 1003 : solve(s, i, k - 1, 0) % 1003;
            rightF = dp[k + 1][j][0] != -1 ? dp[k + 1][j][0] % 1003 : solve(s, k + 1, j, 0) % 1003;
            
            if (s.charAt(k) == '&') {
                if (isTrue == 1) {
                    ans += leftT * rightT;
                } else {
                    ans += leftF * rightF + leftT * rightF + leftF * rightT;
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue == 1) {
                    ans += leftT * rightT + leftT * rightF + leftF * rightT;
                } else {
                    ans += leftF * rightF;
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue == 1) {
                    ans += leftF * rightT + leftT * rightF;
                } else {
                    ans += leftT * rightT + leftF * rightF;
                }
            }
            ans %= 1003;
        }
        
        dp[i][j][isTrue] = ans;
        return ans;
    }
    
    public int countWays(int N, String S) {
        return solve(S, 0, N - 1, 1);
    }
}
