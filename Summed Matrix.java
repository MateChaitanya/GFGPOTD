class Solution {
    static long sumMatrix(long n, long q) {
        // Calculate the range of valid i values
        long start = Math.max(1, q - n);
        long end = Math.min(n, q - 1);
        
        // The count of valid cells
        long count = Math.max(0, end - start + 1);
        
        return count;
    }
}
