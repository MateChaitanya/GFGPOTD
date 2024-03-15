class Solution {

    public Node sort(Node head) {
        // Base case: if head is null or there's only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Split the linked list into two separate lists: one ascending and one descending
        Node[] ascendingDescendingLists = splitList(head);
        
        // Reverse the descending list
        Node descendingHead = reverseList(ascendingDescendingLists[1]);
        
        // Merge the two sorted lists
        return mergeLists(ascendingDescendingLists[0], descendingHead);
    }
    
    // Helper function to split the linked list into ascending and descending lists
    private Node[] splitList(Node head) {
        Node ascendingHead = null;
        Node ascendingTail = null;
        Node descendingHead = null;
        Node descendingTail = null;
        
        Node curr = head;
        boolean isAscending = true;
        
        while (curr != null) {
            Node next = curr.next;
            curr.next = null; // detach the current node
            
            if (isAscending) {
                if (ascendingHead == null) {
                    ascendingHead = curr;
                    ascendingTail = curr;
                } else {
                    ascendingTail.next = curr;
                    ascendingTail = curr;
                }
            } else {
                if (descendingHead == null) {
                    descendingHead = curr;
                    descendingTail = curr;
                } else {
                    descendingTail.next = curr;
                    descendingTail = curr;
                }
            }
            
            isAscending = !isAscending;
            curr = next;
        }
        
        return new Node[]{ascendingHead, descendingHead};
    }
    
    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    // Helper function to merge two sorted linked lists
    private Node mergeLists(Node list1, Node list2) {
        Node dummy = new Node(0); // dummy node to facilitate merging
        Node tail = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        
        // Append the remaining nodes
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        
        return dummy.next;
    }
}
