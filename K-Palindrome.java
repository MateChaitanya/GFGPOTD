class Solution {
    public int kPalindrome(String str, int n, int k) {
        // Check if a string is a palindrome
        boolean isPalindrome[][] = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    isPalindrome[i][j] = true;
                } else if (len == 2) {
                    isPalindrome[i][j] = (str.charAt(i) == str.charAt(j));
                } else {
                    isPalindrome[i][j] = (str.charAt(i) == str.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }
        
        // Find the minimum number of deletions to make the string a palindrome
        int deletions[][] = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    deletions[i][j] = 0;
                } else if (len == 2) {
                    deletions[i][j] = (str.charAt(i) == str.charAt(j)) ? 0 : 1;
                } else {
                    deletions[i][j] = (str.charAt(i) == str.charAt(j)) ? deletions[i + 1][j - 1] : Math.min(deletions[i + 1][j], deletions[i][j - 1]) + 1;
                }
            }
        }
        
        // Check if the string is a K-palindrome
        return deletions[0][n - 1] <= k ? 1 : 0;
    }
}
