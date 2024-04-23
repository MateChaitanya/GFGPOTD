class Solution {
     static int firstElement(int n) {
        // code here
        if(n==1 || n==2)return 1;
        int a=1,b=1,ans=0,mod=1000000007;
        for(int i=3;i<=n;i++){
            ans=(a+b)%mod;
            a=b;
            b=ans;
        }
        return ans;
    }
    }
