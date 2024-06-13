class Solution
{
    int m = 1000000007;
  public int padovanSequence(int n)
    {
        //code here.
        if(n<=2)
        return 1;
        int a=1,b=1,c=1,d=0;
        
        
        for(int i=3; i<=n ;i++){
            d=(a%m + b%m)%m;
            a=b; b=c; c=d;
        } 
        return d;
    }
    
}
