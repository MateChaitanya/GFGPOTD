class Solution
{
    
        public int firstElementKTime(int n, int k, int[] a) { 
        HashMap<Integer,Integer> mm = new HashMap<>();
        for(int i=0;i<n;i++){
            mm.putIfAbsent(a[i],0);
            mm.put(a[i],mm.get(a[i])+1);
            if(mm.get(a[i])==k)return a[i];
        }
        return -1;
    } 
    
}
