class Solution {
    void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Increment left index while we see 0 at left
            while (arr[left] == 0 && left < right) {
                left++;
            }
            // Decrement right index while we see 1 at right
            while (arr[right] == 1 && left < right) {
                right--;
            }
            // If left is less than right, then swap arr[left] and arr[right]
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}
