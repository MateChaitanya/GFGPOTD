class Solution {

    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        // Edge case: If the array is empty, return 0 (though not stated in the problem).
        if (arr.length == 0) return 0;

        // Initialize maxSoFar with the first element (to handle negative values as well)
        int maxSoFar = arr[0];
        int currentMax = arr[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update currentMax to either include the current element in the subarray
            // or start a new subarray from the current element
            currentMax = Math.max(arr[i], currentMax + arr[i]);

            // Update maxSoFar to track the maximum sum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // Return the maximum sum found
        return maxSoFar;
    }
}
