 class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
        // Your Code Here   
        if(n%k!=0) return 0;
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i=0; i<n; i=i+k){
            String sub = s.substring(i,i+k);
            hm.put(sub,hm.getOrDefault(sub,0)+1);
        }
        
        int x = hm.size();
        if(x==1) return 1;
        if(x==2) for(Integer val : hm.values()) if(val==1) return 1;
        return 0;
        
    }
}
