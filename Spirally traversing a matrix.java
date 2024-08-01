class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
     public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        int n=matrix.length,m=matrix[0].length,s=n*m;
        ArrayList<Integer> ans = new ArrayList<>();
        // a -> row start, b -> col start, c-> row end, d-> col end
        int a=0,b=0,c=n-1,d=m-1;
        while(ans.size()<s){
            for(int i=b;i<=d && ans.size()<s;i++)ans.add(matrix[a][i]);
            a++;
            for(int i=a;i<=c && ans.size()<s;i++)ans.add(matrix[i][d]);
            d--;
            for(int i=d;i>=b && ans.size()<s;i--)ans.add(matrix[c][i]);
            c--;
            for(int i=c;i>=a && ans.size()<s;i--)ans.add(matrix[i][b]);
            b++;
        }
        return ans;
    }
}
