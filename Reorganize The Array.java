class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        int n = arr.size();
        
        for (int i = 0; i < n; i++) {
            while (arr.get(i) != i && arr.get(i) != -1) {
                int correctIndex = arr.get(i);
                
                // If the element at the correctIndex is already in place, break the loop
                if (arr.get(correctIndex) == correctIndex) {
                    arr.set(i, -1); // Since it can't be placed anywhere else, mark it as -1
                    break;
                }
                
                // Swap arr[i] with arr[correctIndex]
                int temp = arr.get(i);
                arr.set(i, arr.get(correctIndex));
                arr.set(correctIndex, temp);
            }
        }
        
        return arr;
    }
}
