class Solution {
    
    boolean hasPathSum(Node root, int target) {
       if (root == null) {
            return false;
        }
       
        if (root.left == null && root.right == null) {
            return target == root.data;
        }
        
        int newTarget = target - root.data;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
}
