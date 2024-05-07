class Tree
{
   public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.size()!=0){
            Node temp=q.remove();
            ans.add(temp.data);
            if(temp.right!=null)q.add(temp.right);
            if(temp.left!=null)q.add(temp.left);
        }
        Collections.reverse(ans);
        return ans;
    }
}      
