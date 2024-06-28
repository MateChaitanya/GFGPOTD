class Solution {
    public String pattern(int[][] arr) {
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            //check if ith row is Palindrome 
            if(Row_Palindrome(i,n,arr))   return i+" R";
        }
        
        for(int i=0;i<n;i++){
            //check if ith row is Palindrome 
            if(Column_Palindrome(i,n,arr))   return i+" C";
        }
        
        return "-1";
    }
    boolean Row_Palindrome(int row,int n,int a[][]){
        int l=0, r=n-1;
        while(l<r){
            if(a[row][l]==a[row][r]){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
    boolean Column_Palindrome(int col,int n,int a[][]){
        int l=0, r=n-1;
        while(l<r){
            if(a[l][col]==a[r][col]){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
