class Solution {
    // Function to find the missing number
    int missingNumber(int n, int arr[]) {
        // Calculate the sum of the first n natural numbers
        int totalSum = n * (n + 1) / 2;
        
        // Calculate the sum of elements in the array
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }
        
        // The missing number is the difference between the total sum and the array sum
        return totalSum - arraySum;
    }
}
