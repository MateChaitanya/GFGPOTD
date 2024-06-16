class Solution {
     public static ArrayList<Integer> getPrimes(int n) {
        // code here
        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i=2;i*i<=n;i++) {
            if(prime[i]) {
                for(int j=i*i;j<=n;j+=i)prime[j]=false;
            }
        }
        for(int i=2;i<=n;i++){
            if(prime[i] && prime[n-i]){
                ans.add(i);
                ans.add(n-i);
                return ans;
            }
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
}
