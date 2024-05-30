class Solution {
    static int dp[][];
    static int mod = 1000000007;
    public static int countWays(String s1, String s2) {
        
        int n = s1.length(), m=s2.length();
        dp = new int[n+1][m+1];
        for(int x[] : dp)
        Arrays.fill(x,-1);
        
      return fun(s1,s2,n,m);
    }
    static int fun(String s1, String s2, int n, int m){
        if(m==0) return 1;
        if(n==0) return 0;
        
        if(dp[n][m]!=-1)
        return  dp[n][m];
        
        if(s1.charAt(n-1)==s2.charAt(m-1))
          return dp[n][m] =  (fun(s1,s2, n-1, m-1)%mod + fun(s1, s2, n-1,m)%mod)%mod;
           
        else  
        return dp[n][m] = fun(s1,s2,n-1,m);
        
    }

   
}
