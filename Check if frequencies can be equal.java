class Solution {
    boolean sameFreq(String s) {
        // Count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Count the frequency of frequencies
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : freqMap.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }
        
        // If there's only one frequency, or if there are exactly two frequencies
        // and one of them has a count of 1, return true, otherwise false
        return freqCount.size() == 1 || (freqCount.size() == 2 && (freqCount.containsValue(1) && (Math.abs(freqCount.keySet().toArray(new Integer[0])[0] - freqCount.keySet().toArray(new Integer[0])[1]) == 1 || freqCount.keySet().contains(1))));
    }
}
