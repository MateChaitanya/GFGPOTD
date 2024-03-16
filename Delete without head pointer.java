class Solution {
    void deleteNode(Node del_node) {
        // Check if the given node or its next node is null
        if (del_node == null || del_node.next == null)
            return;

        // Copy the value of the next node to the given node
        del_node.data = del_node.next.data;

        // Delete the next node
        del_node.next = del_node.next.next;
    }
}
