class Solution {
    static List<Long> jugglerSequence(long n) {
        // code here
        List<Long> ans = new ArrayList<Long>();
        while(n!=1){
            ans.add(n);
            if(n%2==1){
                n=(long)Math.pow(Math.sqrt(n),3);
            }
            else{
                n=(long)Math.sqrt(n);
            }
        }
        ans.add(1L);
        return ans;
    }
}
