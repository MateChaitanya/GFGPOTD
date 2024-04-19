class Solution {
    public ArrayList<Integer> findMissing(int[] a, int[] b, int n, int m) {
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st.add(b[i]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!st.contains(a[i])) {
                ans.add(a[i]);
            }
        }
        
        return ans;
    }
}
