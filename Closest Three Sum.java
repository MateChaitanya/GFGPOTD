class Solution {
    static int threeSumClosest(int[] arr, int target) {
        // Sort the array to use the two-pointer technique
        Arrays.sort(arr);
        int n = arr.length;
        int closestSum = Integer.MAX_VALUE;
        int minDifference = Integer.MAX_VALUE;

        // Iterate through the array, fixing one element
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Use two-pointer technique to find the best pair
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                int currentDifference = Math.abs(currentSum - target);

                // Check if this sum is closer to the target
                if (currentDifference < minDifference || 
                    (currentDifference == minDifference && currentSum > closestSum)) {
                    minDifference = currentDifference;
                    closestSum = currentSum;
                }

                // Move the pointers based on the sum comparison
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}
