class Solution {
    long max_Books(int arr[], int n, int k) {
        long count = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                count += arr[i];
            } else {
                count = 0;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
