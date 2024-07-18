class Solution {
     public int alternatingMaxLength(int[] arr) {
        // code here
        int dec=1,inc=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])dec=inc+1;
            else if(arr[i]>arr[i-1])inc=dec+1;
        }
        return Math.max(inc,dec);
    }
}
