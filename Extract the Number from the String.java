class Solution {
    long ExtractNumber(String sentence) {
        // Split the sentence by spaces to extract words and numbers
        String[] words = sentence.split(" ");
        long maxNumber = -1;

        for (String word : words) {
            // Check if the current word is a number
            if (isNumber(word) && !word.contains("9")) {
                // Parse the number and compare it with the current maxNumber
                long num = Long.parseLong(word);
                if (num > maxNumber) {
                    maxNumber = num;
                }
            }
        }

        return maxNumber;
    }

    // Helper method to check if a string is a valid number
    private boolean isNumber(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
