class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head==null || head.next==null)
        return null;
        Node slow=head, fast=head;
        Node preptr = slow;
        while(fast!=null && fast.next!=null){
            preptr=slow;
            slow=slow.next;
            fast = fast.next.next;
        }
        preptr.next = slow.next; 
        //preptr.next = preptr.next.next;
        return head;
    }
}
