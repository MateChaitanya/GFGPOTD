class Solution {
    public static int wordBreak(String A, ArrayList<String> B) {
        // Create a set of dictionary words for faster lookup
        Set<String> dictionary = new HashSet<>(B);
        
        // Create a boolean array to store whether a substring ending at index i can be segmented
        boolean[] dp = new boolean[A.length() + 1];
        dp[0] = true; // An empty string can always be segmented
        
        // Iterate through each character in the string
        for (int i = 1; i <= A.length(); i++) {
            // Check if the substring up to index i can be segmented
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictionary.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // Return whether the entire string can be segmented
        return dp[A.length()] ? 1 : 0;
    }
}
