class Solution {
    public int pairWithMaxSum(int[] arr) {
        // code here
        if(arr.length < 2){
        return -1;
    }
    int maxSum = Integer.MIN_VALUE;

        // Traverse the array and calculate the sum of consecutive pairs
        for (int i = 0; i < arr.length - 1; i++) {
            // Calculate the sum of the current pair (arr[i], arr[i+1])
            int currentSum = arr[i] + arr[i + 1];

            // Update the maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
