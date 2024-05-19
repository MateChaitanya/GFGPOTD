class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        int low = 0;
        int high = n - 1;
        int closest = Integer.MAX_VALUE;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if arr[mid] is closest to k
            if (Math.abs(arr[mid] - k) < Math.abs(closest - k)) {
                closest = arr[mid];
            } else if (Math.abs(arr[mid] - k) == Math.abs(closest - k)) {
                // If both arr[mid] and closest have the same absolute difference with k,
                // choose the greater value as closest
                closest = Math.max(closest, arr[mid]);
            }
            
            if (arr[mid] == k) {
                // If k is found in the array, it's the closest value
                return k;
            } else if (arr[mid] < k) {
                // If arr[mid] is less than k, search in the right half
                low = mid + 1;
            } else {
                // If arr[mid] is greater than k, search in the left half
                high = mid - 1;
            }
        }
        
        return closest;
    }
}
