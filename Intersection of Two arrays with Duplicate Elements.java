class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // Use a HashSet to store elements of the first array
        HashSet<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }
        
        // Use another HashSet to find the intersection
        HashSet<Integer> intersection = new HashSet<>();
        for (int num : b) {
            if (setA.contains(num)) {
                intersection.add(num);
            }
        }
        
        // Convert the HashSet to an ArrayList and return
        return new ArrayList<>(intersection);
    }
}
