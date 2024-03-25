class Solution {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> result = new ArrayList<>();
        generateBinaryNumbers("", N, 0, 0, result);
        return result;
    }

    // Recursive function to generate all valid n-bit binary numbers
    private void generateBinaryNumbers(String current, int n, int ones, int zeros, ArrayList<String> result) {
        // Base case: if the length of the current binary number is n
        if (current.length() == n) {
            result.add(current);
            return;
        }

        // Append '1' if the number of '1's is greater than or equal to the number of '0's in the prefix
        if (ones >= zeros) {
            generateBinaryNumbers(current + '1', n, ones + 1, zeros, result);
        }

        // Always append '0' if it doesn't violate the condition
        if (zeros < n / 2) {
            generateBinaryNumbers(current + '0', n, ones, zeros + 1, result);
        }
    }
}
