class Solution
{
    //Function to find the maximum number of cuts.
      int help(int n,int x,int y,int z,int dp[]){
        if(n<0)return Integer.MIN_VALUE;
        if(n==0)return 0;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=1+Math.max(help(n-x,x,y,z,dp),Math.max(help(n-y,x,y,z,dp),help(n-z,x,y,z,dp)));
    }
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = help(n,x,y,z,dp);
        return ans<0?0:ans;
    }
}
