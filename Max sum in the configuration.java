class Solution {
    long max_sum(int a[], int n) {
        long totalSum = 0;
        long indexSum = 0;

        // Calculate the total sum of elements and the sum of index * element for the original array
        for (int i = 0; i < n; i++) {
            totalSum += a[i];
            indexSum += (long) i * a[i];
        }

        long maxSum = indexSum;

        // Iterate through all possible rotations to find the maximum sum
        for (int i = 1; i < n; i++) {
            // Calculate the sum of elements for the rotated array
            indexSum += totalSum - (long) n * a[n - i];

            // Update maxSum if the current rotation yields a higher sum
            maxSum = Math.max(maxSum, indexSum);
        }

        return maxSum;
    }
}
