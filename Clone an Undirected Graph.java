public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // Map to store the mapping of original nodes to their clones
        Map<Node, Node> cloneMap = new HashMap<>();
        
        // Create a clone of the starting node and put it in the map
        Node clonedNode = new Node(node.val);
        cloneMap.put(node, clonedNode);
        
        // Use BFS to traverse the original graph and clone its nodes
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            Node clonedCurrNode = cloneMap.get(currNode);
            
            for (Node neighbor : currNode.neighbors) {
                // If the neighbor has not been cloned yet, create its clone and put it in the map
                if (!cloneMap.containsKey(neighbor)) {
                    Node clonedNeighbor = new Node(neighbor.val);
                    cloneMap.put(neighbor, clonedNeighbor);
                    queue.offer(neighbor);
                }
                // Add the clone of the neighbor to the cloned current node's neighbors list
                clonedCurrNode.neighbors.add(cloneMap.get(neighbor));
            }
        }
        
        return clonedNode;
    }
}
