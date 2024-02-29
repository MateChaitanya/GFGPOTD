class Solution {
    long sumBitDifferences(int[] arr, int n) {
        long ans = 0; // Initialize the answer variable
        
        // Iterate through each bit position (0 to 31)
        for (int i = 0; i < 32; i++) {
            // Count the number of set bits at the current bit position
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }
            }
            // Update the answer by adding the bit differences at the current bit position
            ans += (long) count * (n - count) * 2;
        }
        
        return ans;
    }
}
