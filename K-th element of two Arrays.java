class Solution {
    public long kthElement(int k, int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 > n2) {
            // Ensuring that binary search happens on the smaller array
            return kthElement(k, arr2, arr1);
        }

        int low = Math.max(0, k - n2);
        int high = Math.min(n1, k);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        
        return 1; // This line is never reached
    }
}
