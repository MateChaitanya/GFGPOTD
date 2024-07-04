class Solution {
    private Map<String, Integer> subtreeMap = new HashMap<>();
    private List<Node> duplicateRoots = new ArrayList<>();

    public List<Node> printAllDups(Node root) {
        serializeSubtree(root);
        return duplicateRoots;
    }

    private String serializeSubtree(Node node) {
        if (node == null) {
            return "#";
        }

        // Serialize the subtree rooted at `node`
        String leftSerialization = serializeSubtree(node.left);
        String rightSerialization = serializeSubtree(node.right);
        String subtreeSerialization = node.data + "," + leftSerialization + "," + rightSerialization;

        // Check if this subtree serialization already exists in the map
        subtreeMap.put(subtreeSerialization, subtreeMap.getOrDefault(subtreeSerialization, 0) + 1);

        // If this subtree has been seen exactly twice, add its root to the result
        if (subtreeMap.get(subtreeSerialization) == 2) {
            duplicateRoots.add(node);
        }

        return subtreeSerialization;
    }
}
