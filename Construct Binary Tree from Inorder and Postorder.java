class GfG {
    // Function to return a tree created from postorder and inorder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Call the helper function to construct the tree.
        return buildTreeHelper(in, post, 0, n - 1, 0, n - 1);
    }

    // Helper function to construct the tree recursively.
    Node buildTreeHelper(int in[], int post[], int inStart, int inEnd, int postStart, int postEnd) {
        // Base case: if start index of inorder array exceeds end index,
        // then no elements left to construct the subtree.
        if (inStart > inEnd)
            return null;

        // Create a new node with the value of the current root element.
        Node root = new Node(post[postEnd]);

        // Find the index of current root element in inorder array.
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.data) {
                inIndex = i;
                break;
            }
        }

        // Recursively construct left and right subtrees.
        // Elements to the left of inIndex in inorder array form left subtree,
        // and elements to the right form right subtree.
        root.left = buildTreeHelper(in, post, inStart, inIndex - 1, postStart, postStart + inIndex - inStart - 1);
        root.right = buildTreeHelper(in, post, inIndex + 1, inEnd, postStart + inIndex - inStart, postEnd - 1);

        return root;
    }
}
