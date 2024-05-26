class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int n = x.length(),m = y.length();
	    int dp[][] = new int[n+1][m+1];
	    for(int i=0;i<=n;i++)
	    dp[i][0]=0;
	    for(int i=0;i<=m;i++)
	    dp[0][i]=0;
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=m;j++){
	            if(x.charAt(i-1)==y.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
	            else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
	        }
	    }
	    return (n-dp[n][m])*costX+(m-dp[n][m])*costY;
    }
}
