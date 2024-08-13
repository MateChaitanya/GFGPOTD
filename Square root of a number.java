class Solution {
    long floorSqrt(long n) {
        long low = 1, high = n, ans = 0;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long midSquare = mid * mid;
            
            if (midSquare == n) {
                return mid;
            } else if (midSquare < n) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
}
