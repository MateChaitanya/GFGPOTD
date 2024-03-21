class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	     ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Initialize a deque to support adding and removing nodes from both ends.
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);

        // Flag to indicate the direction of traversal, start with true for left to right.
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            // Level size indicates the number of nodes at the current level.
            int levelSize = deque.size();
            // List to store the nodes of the current level.
            ArrayList<Integer> level = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; ++i) {
                Node currentNode;
                if (leftToRight) {
                    // Remove from the front of the deque if left to right.
                    currentNode = deque.pollFirst();
                    // Add children to the end of the deque.
                    if (currentNode.left != null) deque.offerLast(currentNode.left);
                    if (currentNode.right != null) deque.offerLast(currentNode.right);
                } else {
                    // Remove from the end of the deque if right to left.
                    currentNode = deque.pollLast();
                    // Add children to the front of the deque.
                    if (currentNode.right != null) deque.offerFirst(currentNode.right);
                    if (currentNode.left != null) deque.offerFirst(currentNode.left);
                }
                // Add the current node's data to the level list.
                level.add(currentNode.data);
            }
            // After completing each level, add all elements of the level to the result and flip the direction.
            result.addAll(level);
            leftToRight = !leftToRight;
        }

        return result;
	}
}
