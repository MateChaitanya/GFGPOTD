class Tree
{
    //Function to return list containing elements of left view of binary tree.
    void help(Node root,ArrayList<Integer> ans,int level,Map<Integer,Integer> mm){
        if(root==null)return;
        if(mm.get(level)==null){
            ans.add(root.data);
            mm.put(level,1);
        }
        level++;
        help(root.left,ans,level,mm);
        help(root.right,ans,level,mm);
    }
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
       ArrayList<Integer> ans = new ArrayList<>();
       Map<Integer,Integer> mm = new HashMap<>();
       help(root,ans,0,mm);
       return ans;
    }
}
