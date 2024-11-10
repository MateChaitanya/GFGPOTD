class Solution {
    // Function to return a list containing the union of the two arrays.
     public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        int i=0,j=0,n=a.length,m=b.length;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<n || j<m){
            int num1 = i<n?a[i]:Integer.MAX_VALUE;
            int num2 = j<m?b[j]:Integer.MAX_VALUE;
            if(num1<num2){
                ans.add(num1);
                i++;
            }
            else if(num2<num1){
                ans.add(num2);
                j++;
            }
            else{
                ans.add(num1);
                i++;
                j++;
            }
        }
        return ans;
    }

}
