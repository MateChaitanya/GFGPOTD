class Solution {
    String removeDups(String str) {
        // boolean array to track seen characters
        boolean[] seen = new boolean[26];
        StringBuilder result = new StringBuilder();

        // iterate through each character in the string
        for (char c : str.toCharArray()) {
            // calculate index for character 'a' to 'z'
            int index = c - 'a';
            
            // if character has not been seen, append to result
            if (!seen[index]) {
                seen[index] = true;
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
