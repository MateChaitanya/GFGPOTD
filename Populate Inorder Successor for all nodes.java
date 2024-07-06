class Solution {
    // Previous node reference
    private Node prev = null;

    public void populateNext(Node root) {
        // Call the recursive helper function to populate the next pointers
        populateNextHelper(root);
    }

    // Helper function for in-order traversal and populating next pointers
    private void populateNextHelper(Node node) {
        if (node == null) {
            return;
        }

        // Recur on the left subtree
        populateNextHelper(node.left);

        // Set the next pointer of the previous node to the current node
        if (prev != null) {
            prev.next = node;
        }

        // Update the previous node to the current node
        prev = node;

        // Recur on the right subtree
        populateNextHelper(node.right);
    }
}
