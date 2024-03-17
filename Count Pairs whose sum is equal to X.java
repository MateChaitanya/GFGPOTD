class Solution {
    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        // Initialize a HashSet to store elements from head1
        HashSet<Integer> set = new HashSet<>();

        // Count of pairs whose sum is x
        int count = 0;

        // Add elements of head1 to HashSet
        for (int num : head1) {
            set.add(num);
        }

        // Iterate through elements of head2
        for (int num : head2) {
            // Check if (x - current_element) exists in the HashSet
            if (set.contains(x - num)) {
                count++;
            }
        }

        return count;
    }
}
