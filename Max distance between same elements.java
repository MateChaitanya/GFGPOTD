import java.util.HashMap;

class Solution {
    public int maxDistance(int[] arr) {
        // Create a HashMap to store the first occurrence of each element
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxDist = 0; // Variable to store the maximum distance

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // If the element is seen for the first time, store its index
            if (!firstOccurrence.containsKey(arr[i])) {
                firstOccurrence.put(arr[i], i);
            } else {
                // If the element has been seen before, calculate the distance
                int dist = i - firstOccurrence.get(arr[i]);
                // Update the maximum distance
                maxDist = Math.max(maxDist, dist);
            }
        }

        return maxDist;
    }
}
