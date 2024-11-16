class Solution {
    public int[] reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        
        // Use two-pointer approach to swap elements
        while (start < end) {
            // Swap elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            // Move pointers towards the center
            start++;
            end--;
        }
        
        // Return the reversed array
        return arr;
    }
}
