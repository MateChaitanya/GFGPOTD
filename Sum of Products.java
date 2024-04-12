class Solution {
    static long pairAndSum(int n, long arr[]) {
        long sum = 0;
        int[] countBits = new int[32]; // to store the count of set bits at each position
        
        // Counting the number of set bits at each position
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if ((arr[i] & (1 << j)) != 0) {
                    countBits[j]++;
                }
            }
        }
        
        // Calculating the sum
        for (int i = 0; i < 32; i++) {
            sum += (long) countBits[i] * (countBits[i] - 1) / 2 * (1 << i); // (countC2 choose 2) * 2^i
        }
        
        return sum;
    }
}
