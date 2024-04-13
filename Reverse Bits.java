class Solution {
    static long reversedBits(long x) {
        long reversed = 0;
        int bitCount = 32; // Assuming 32-bit integers
        
        while (bitCount-- > 0) {
            reversed <<= 1; // Left shift by 1 to make space for the next bit
            reversed |= (x & 1); // Taking the rightmost bit of x and adding it to reversed
            x >>= 1; // Right shift x to consider the next bit
        }
        
        return reversed;
    }
}
