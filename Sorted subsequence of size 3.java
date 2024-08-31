class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
     public List<Integer> find3Numbers(int[] arr) {
        // code here
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int leftSmall[] = new int[n];
        int rightLarge[] = new int[n];
        leftSmall[0]=arr[0];
        for(int i=1;i<n;i++)leftSmall[i]=Math.min(arr[i],leftSmall[i-1]);
        rightLarge[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)rightLarge[i]=Math.max(arr[i],rightLarge[i+1]);
        for(int i=1;i<=n-2;i++){
            if(leftSmall[i-1]<arr[i] && arr[i]<rightLarge[i+1]){
                ans.add(leftSmall[i-1]);
                ans.add(arr[i]);
                ans.add(rightLarge[i+1]);
                break;
            }
        }
        return ans;
    }

}
