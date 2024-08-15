 public Node addOne(Node head) {
        // code here.
        Node curr=head,nxt=head.next,prev=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        Node lastHead = prev;
        while(prev!=null){
            if(prev.data!=9){
                prev.data+=1;
                break;
            }
            else prev.data=0;
            prev=prev.next;
        }
        if(prev==null)head.next=new Node(1);
        curr=lastHead;
        nxt=lastHead.next;
        prev=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
