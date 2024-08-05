class Solution
{
    //Function to return a list containing the bottom view of the given tree.
     public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Map<Integer,Integer> mm = new HashMap<>();
        root.hd=0;
        q.add(root);
        int mn=0,mx=0;
        while(!q.isEmpty()){
            Node temp = q.remove();
            mm.put(temp.hd,temp.data);
            mn=Math.min(mn,temp.hd);
            mx=Math.max(mx,temp.hd);
            if(temp.left!=null){
                temp.left.hd=temp.hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd=temp.hd+1;
                q.add(temp.right);
            }
        }
        for(int i=mn;i<=mx;i++){
            ans.add(mm.get(i));
        }
        return ans;
    }

}
