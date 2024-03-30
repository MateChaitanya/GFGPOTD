class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // Base case: if the tree is empty, return -1
        if (root == null)
            return -1;
        
        // Traverse left until we reach the leftmost leaf node
        while (root.left != null) {
            root = root.left;
        }
        
        // Return the value of the leftmost leaf node
        return root.data;
    }
}
