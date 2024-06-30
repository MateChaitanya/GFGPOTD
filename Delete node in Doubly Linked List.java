class Solution {
    public Node deleteNode(Node head, int x) {
        // If linked list is empty
        if (head == null) {
            return null;
        }

        // If the node to be deleted is the head node
        if (x == 1) {
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            return newHead;
        }

        // Traverse the list to find the node to be deleted
        Node current = head;
        for (int i = 1; current != null && i < x; i++) {
            current = current.next;
        }

        // If the position is more than the number of nodes
        if (current == null) {
            return head;
        }

        // Change the next of the previous node
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        // Change the previous of the next node
        if (current.next != null) {
            current.next.prev = current.prev;
        }

        return head;
    }
}
