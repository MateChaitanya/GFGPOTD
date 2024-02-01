class Solution {
    public static boolean checkPangram(String s) {
        // Create an array to track the presence of each alphabet letter
        boolean[] present = new boolean[26];

        // Traverse the given string and mark the presence of each letter
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if the character is an alphabet letter (case-insensitive)
            if ('a' <= ch && ch <= 'z') {
                present[ch - 'a'] = true;
            } else if ('A' <= ch && ch <= 'Z') {
                present[ch - 'A'] = true;
            }
        }

        // Check if all alphabet letters are present
        for (boolean isPresent : present) {
            if (!isPresent) {
                return false;
            }
        }

        // If all letters are present, return true
        return true;
    }
}
