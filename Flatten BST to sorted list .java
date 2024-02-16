class Solution {
    static Node prev=null,ans=null;
    void help(Node root){
        if(root==null) return;
        help(root.left);
        if(prev!=null){
            prev.right=root;
            root.left=null;
        }
        else ans=root;
        prev=root;
        help(root.right);
    }
    public Node flattenBST(Node root) {
        ans=null;
        prev=null;
        help(root);
        if (ans != null)
            ans.left = null;
        return ans;
    }
}
