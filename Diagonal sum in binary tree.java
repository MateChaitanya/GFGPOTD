class Tree {
    public static ArrayList<Integer> diagonalSum(Node root) {
        ArrayList<Integer> diagonalSums = new ArrayList<>();
        if (root == null) return diagonalSums;

        // HashMap to store the diagonal sums
        HashMap<Integer, Integer> diagonalSumMap = new HashMap<>();
        
        // Recursive function to calculate diagonal sums
        diagonalSumHelper(root, diagonalSumMap, 0);
        
        // Add diagonal sums to the result list
        for (int i = 0; i < diagonalSumMap.size(); i++) {
            diagonalSums.add(diagonalSumMap.get(i));
        }

        return diagonalSums;
    }

    // Helper function to calculate diagonal sums recursively
    private static void diagonalSumHelper(Node node, HashMap<Integer, Integer> diagonalSumMap, int diagonal) {
        if (node == null) return;

        // Update diagonal sum map
        diagonalSumMap.put(diagonal, diagonalSumMap.getOrDefault(diagonal, 0) + node.data);

        // Recur for left child with diagonal + 1 and right child with same diagonal
        diagonalSumHelper(node.left, diagonalSumMap, diagonal + 1);
        diagonalSumHelper(node.right, diagonalSumMap, diagonal);
    }
}
