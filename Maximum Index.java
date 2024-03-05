class Solution {
    // Function to find the maximum index difference.
    static int maxIndexDiff(int[] a, int n) {
        int MAX = 0;
        int i = 0, j = n - 1;

        while (i < n) {
            if (a[i] <= a[j]) {
                MAX = Math.max(MAX, j - i);
                j = n - 1;
                i++;
            } else {
                j--;
            }
        }

        return MAX;
    }
}
