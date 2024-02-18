class Solution {
    public static int sumOfLeafNodes(Node root) {
        if (root == null) // If tree is empty
            return 0;
        
        if (root.left == null && root.right == null) // If root is a leaf node
            return root.data;
        
        // Recursively find sum of leaf nodes in left and right subtrees
        return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
    }
}
