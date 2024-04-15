class Solution {
    public static int[] countElements(int a[], int b[], int n, int query[], int q) {
        int[] result = new int[q];
        
        // Sort array b
        Arrays.sort(b);
        
        // Iterate through each query
        for (int i = 0; i < q; i++) {
            int count = 0;
            int index = query[i];
            int value = a[index];
            
            // Count elements in array b less than or equal to a[index]
            for (int j = 0; j < n; j++) {
                if (b[j] <= value) {
                    count++;
                } else {
                    break; // Optimization: Since b is sorted, no need to continue checking
                }
            }
            
            result[i] = count;
        }
        
        return result;
    }
}
