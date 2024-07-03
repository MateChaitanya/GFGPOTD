class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node removeAllDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Pointer to the current node being examined
        Node current = head;
        // Previous non-duplicate node
        Node prev = null;
        // New head of the list
        Node newHead = null;

        while (current != null) {
            boolean isDuplicate = false;

            // Check if the current node has duplicates
            while (current.next != null && current.data == current.next.data) {
                current = current.next;
                isDuplicate = true;
            }

            if (isDuplicate) {
                // Skip all duplicates
                current = current.next;
            } else {
                // If no duplicates, link the node to the new list
                if (newHead == null) {
                    newHead = current;
                } else {
                    prev.next = current;
                }
                // Move prev pointer to current node
                prev = current;
                // Move current pointer to the next node
                current = current.next;
            }
        }

        // Ensure the last node in the new list points to null
        if (prev != null) {
            prev.next = null;
        }

        return newHead;
    }
}

// Helper function to print the linked list
public void printList(Node head) {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
    System.out.println();
}

// Helper function to create a linked list from an array
public Node createList(int[] arr) {
    if (arr.length == 0) {
        return null;
    }
    Node head = new Node(arr[0]);
    Node temp = head;
    for (int i = 1; i < arr.length; i++) {
        temp.next = new Node(arr[i]);
        temp = temp.next;
    }
    return head;
}
