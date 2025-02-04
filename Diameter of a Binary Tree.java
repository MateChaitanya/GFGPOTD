class Solution {
    int ans = 0;
    int diameter(Node root) {
        // Your code here
        calc(root);
        return ans;
    }
    int calc(Node root){
        if(root==null){
           return 0;
        }
        int left = calc(root.left);
        int right = calc(root.right);
        ans=Math.max(ans, left+right);
        return Math.max(left, right)+1;
    }
}
