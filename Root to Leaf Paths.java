class Solution {
    static void help(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp){
         if(root==null) return;
         if(root.left==null&&root.right==null){
             temp.add(root.data);
             ArrayList<Integer> temp2 = new ArrayList<>();
             temp2.addAll(temp);
             ans.add(temp2);
             temp.remove(temp.size()-1);
             return;
         }
         temp.add(root.data);
         help(root.left,ans,temp);
         help(root.right,ans,temp);
         temp.remove(temp.size()-1);
     }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        help(root,ans,temp);
        return ans;
    }
}
