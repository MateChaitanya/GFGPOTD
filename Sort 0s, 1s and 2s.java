class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int n = arr.size(), zero = 0, two = n-1, i = 0;
        while(i<=two){
            if(arr.get(i)==0){
                int temp = arr.get(i);
                arr.set(i,arr.get(zero));
                arr.set(zero,temp);
                zero++;
            }
            else if(arr.get(i)==2){
                int temp = arr.get(i);
                arr.set(i,arr.get(two));
                arr.set(two,temp);
                two--;
                i--;
            }
            i++;
        }
    }
}