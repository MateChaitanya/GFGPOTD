class Solution {
    //Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Base case: if the tree is empty
        if (root == null)
            return result;
        
        // Create a queue for level order traversal
        Queue<Node> queue = new LinkedList<>();
        // Enqueue the root node
        queue.add(root);
        
        // Iterate until the queue is empty
        while (!queue.isEmpty()) {
            // Dequeue the front node
            Node current = queue.poll();
            // Add its value to the result list
            result.add(current.data);
            
            // Enqueue the left child if it exists
            if (current.left != null)
                queue.add(current.left);
            // Enqueue the right child if it exists
            if (current.right != null)
                queue.add(current.right);
        }
        
        return result;
    }
}
