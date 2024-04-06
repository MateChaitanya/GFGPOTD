class Solution {
    // Function to count number of ways to reach the nth stair
    // when order does not matter.
    Long countWays(int n) {
        // Base cases
       return (Long.valueOf(n / 2) + 1);
    }
}
