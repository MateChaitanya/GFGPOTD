class Solution {
    static ArrayList<Integer> recamanSequence(int n) {
        ArrayList<Integer> sequence = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();
        
        sequence.add(0);
        used.add(0);
        
        for (int i = 1; i < n; i++) {
            int nextElement = sequence.get(i - 1) - i;
            if (nextElement < 0 || used.contains(nextElement)) {
                nextElement = sequence.get(i - 1) + i;
            }
            sequence.add(nextElement);
            used.add(nextElement);
        }
        
        return sequence;
    }
}
