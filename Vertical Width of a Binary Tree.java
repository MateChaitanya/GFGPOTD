class Solution {
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {
        if (root == null) {
            return 0;
        }

        // Create a map to store the horizontal distances
        Map<Node, Integer> horizontalDistanceMap = new HashMap<>();
        // Create a queue for BFS
        Queue<Node> queue = new LinkedList<>();

        // Initialize the root node with horizontal distance 0
        horizontalDistanceMap.put(root, 0);
        queue.add(root);

        int minHorizontalDistance = 0;
        int maxHorizontalDistance = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentHorizontalDistance = horizontalDistanceMap.get(currentNode);

            // Update the min and max horizontal distances
            minHorizontalDistance = Math.min(minHorizontalDistance, currentHorizontalDistance);
            maxHorizontalDistance = Math.max(maxHorizontalDistance, currentHorizontalDistance);

            // Check the left child
            if (currentNode.left != null) {
                horizontalDistanceMap.put(currentNode.left, currentHorizontalDistance - 1);
                queue.add(currentNode.left);
            }

            // Check the right child
            if (currentNode.right != null) {
                horizontalDistanceMap.put(currentNode.right, currentHorizontalDistance + 1);
                queue.add(currentNode.right);
            }
        }

        // The vertical width is the difference between the max and min horizontal distances plus one
        return maxHorizontalDistance - minHorizontalDistance + 1;
    }
}
