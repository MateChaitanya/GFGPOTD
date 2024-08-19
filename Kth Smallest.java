class Solution {
   public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int mx = Integer.MIN_VALUE;
        for(int x:arr)mx=Math.max(x,mx);
        int hash[] = new int[mx+1];
        Arrays.fill(hash,0);
        for(int x:arr)hash[x]=1;
        for(int i=1;i<=mx;i++){
            k-=hash[i];
            if(k==0)return i;
        }
        return 0;
    }
}
