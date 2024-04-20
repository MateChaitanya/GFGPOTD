class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // Create a HashSet to store unique elements
        Set<Integer> unionSet = new HashSet<>();
        
        // Add elements from arr1 to unionSet
        for (int i = 0; i < arr1.length; i++) {
            unionSet.add(arr1[i]);
        }
        
        // Add elements from arr2 to unionSet
        for (int i = 0; i < arr2.length; i++) {
            unionSet.add(arr2[i]);
        }
        
        // Convert the set to a sorted ArrayList
        ArrayList<Integer> unionList = new ArrayList<>(unionSet);
        Collections.sort(unionList);
        
        return unionList;
    }
}
