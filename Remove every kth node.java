class Solution
{
   Node delete(Node head, int k)
    {
	// Your code here
	if (k == 1) return null;

       
        Node current = head;
        Node previous = null;
        int count = 1;

       
        while (current != null) {
            if (count % k == 0) {
                
                if (previous != null) {
                    previous.next = current.next;
                }
            } else {
               
                previous = current;
            }
           
            current = current.next;
            count++;
        }
        
        return head;
    }
}
