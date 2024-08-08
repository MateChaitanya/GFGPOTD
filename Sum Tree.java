class Solution {
    // Helper class to store result and sum of subtree
    static class Result {
        boolean isSumTree;
        int sum;
        
        Result(boolean isSumTree, int sum) {
            this.isSumTree = isSumTree;
            this.sum = sum;
        }
    }

    // Function to check if a given binary tree is a Sum Tree
    boolean isSumTree(Node root) {
        return checkSumTree(root).isSumTree;
    }

    // Recursive function to check if a tree is a Sum Tree
    private Result checkSumTree(Node node) {
        // An empty tree is a sum tree
        if (node == null) {
            return new Result(true, 0);
        }

        // Leaf nodes are sum trees by definition
        if (node.left == null && node.right == null) {
            return new Result(true, node.data);
        }

        // Recursively check left and right subtrees
        Result leftResult = checkSumTree(node.left);
        Result rightResult = checkSumTree(node.right);

        // Current node is a sum tree if:
        // - Both left and right subtrees are sum trees
        // - The value of the current node is equal to the sum of left and right subtree values
        boolean isCurrentNodeSumTree = leftResult.isSumTree && rightResult.isSumTree &&
                                       (node.data == leftResult.sum + rightResult.sum);

        // The sum of the current subtree is the sum of the current node's value plus the sums of the left and right subtrees
        int currentSum = node.data + leftResult.sum + rightResult.sum;

        return new Result(isCurrentNodeSumTree, currentSum);
    }
}
