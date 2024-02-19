class Solution {
    public int minValue(String s, int k) {
        // Count the frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Create a max heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        // Remove k characters with highest frequencies
        while (k-- > 0 && !pq.isEmpty()) {
            int highestFreq = pq.poll();
            if (highestFreq > 1) {
                pq.offer(highestFreq - 1);
            }
        }

        // Calculate the minimum value
        int minVal = 0;
        while (!pq.isEmpty()) {
            int f = pq.poll();
            minVal += f * f;
        }

        return minVal;
    }
}
