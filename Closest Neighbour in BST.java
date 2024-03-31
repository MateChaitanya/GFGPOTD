class Solution {
    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        
        if(root==null){
            return -1 ;
        }
        int min = -1 ;
        while(root!=null){
            if(root.key<n){
                min = root.key;
                root = root.right;
            }
            else if(root.key>n){
                root = root.left;
            }
            else{
                return root.key;
            }
        }
        return min;
    }
}
