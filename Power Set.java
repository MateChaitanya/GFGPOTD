class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        int totalSubsequences = (int) Math.pow(2, n);
        
        // Generate all possible subsequences using bitmasking
        for (int i = 1; i < totalSubsequences; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sb.append(s.charAt(j));
                }
            }
            result.add(sb.toString());
        }
        
        // Sort the result lexicographically
        Collections.sort(result);
        
        return result;
    }
}
