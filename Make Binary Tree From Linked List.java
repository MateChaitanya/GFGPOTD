class Solution {
    public Tree convert(Node head, Tree node) {
        if (head == null) {
            return null;
        }
        // Initialize the root of the binary tree
        node = new Tree(head.data);
        head = head.next;

        // Perform BFS to construct the binary tree
        bfs(head, node);
        return node;
    }

    private void bfs(Node head, Tree node) {
        Queue<Tree> q = new LinkedList<>();
        q.add(node);

        while (head != null) {
            Tree parent = q.poll();

            // Add the left child
            if (head != null) {
                parent.left = new Tree(head.data);
                q.add(parent.left);
                head = head.next;
            }

            // Add the right child
            if (head != null) {
                parent.right = new Tree(head.data);
                q.add(parent.right);
                head = head.next;
            }
        }
    }
}
