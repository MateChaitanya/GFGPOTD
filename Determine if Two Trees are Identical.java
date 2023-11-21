
class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node a, Node b)
	{
	    // Code Here
	    if(a==null && b==null) return true;
	    if(a==null || b==null) return false;
	    if(a.data!=b.data) return false;
	    return isIdentical(a.left,b.left) && isIdentical(a.right,b.right);
	}
}
