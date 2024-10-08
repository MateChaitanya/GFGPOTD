 static int help(int n,int w,int wt[],int val[],int index,int dp[][]){
        if(index==n)return 0;
        if(dp[index][w]!=-1)return dp[index][w];
        int nonPick=0,pick=0;
        nonPick = help(n,w,wt,val,index+1,dp);
        if(w>=wt[index]){
            pick = val[index]+help(n,w-wt[index],wt,val,index+1,dp);
        }
        return dp[index][w] = Math.max(nonPick,pick);
    }
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
        int dp[][] = new int[n][W+1];
        for(int temp[]:dp){
            Arrays.fill(temp,-1);
        }
        return help(n,W,wt,val,0,dp);
    }
