class NodeValue {
    int minVal;
    int maxVal;
    int maxSize;

    NodeValue(int minVal, int maxVal, int maxSize) {
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.maxSize = maxSize;
    }
}

// Main Solution class to find the size of the largest BST subtree
class Solution {
    static NodeValue help(Node root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = help(root.left);
        NodeValue right = help(root.right);

        if (left.maxVal < root.data && root.data < right.minVal) {
            return new NodeValue(Math.min(root.data, left.minVal), Math.max(root.data, right.maxVal), left.maxSize + right.maxSize + 1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    // Return the size of the largest subtree which is also a BST
    static int largestBst(Node root) {
        return help(root).maxSize;
    }
}
