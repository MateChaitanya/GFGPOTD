class Solution {

    public ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> ancestors = new ArrayList<>();
        findAncestors(root, target, ancestors);
        return ancestors;
    }

    private boolean findAncestors(Node node, int target, ArrayList<Integer> ancestors) {
        // Base case
        if (node == null) {
            return false;
        }

        // If the target node is found
        if (node.data == target) {
            return true;
        }

        // Check in the left subtree or right subtree
        if (findAncestors(node.left, target, ancestors) || findAncestors(node.right, target, ancestors)) {
            ancestors.add(node.data);
            return true;
        }

        // If target is not present in either left or right subtree
        return false;
    }
}
