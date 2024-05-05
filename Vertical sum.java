class Solution{
   int mn = Integer.MAX_VALUE,mx=Integer.MIN_VALUE;
  void help(Node root,HashMap<Integer,Integer> mm,int vLevel){
      if(root==null)return;
      mn=Math.min(mn,vLevel);
      mx=Math.max(mx,vLevel);
      mm.put(vLevel,mm.getOrDefault(vLevel,0)+root.data);
      help(root.left,mm,vLevel-1);
      help(root.right,mm,vLevel+1);
  }
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        HashMap<Integer,Integer> mm = new HashMap<>();
        help(root,mm,0);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=mn;i<=mx;i++){
            if(mm.get(i)!=null)ans.add(mm.get(i));
        }
        return ans;
    }
}
