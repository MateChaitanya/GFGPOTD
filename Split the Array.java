class Solution {

    public static int countgroup(int arr[]) {
        int MOD = 1000000007;
        int n = arr.length;

        // XOR of all elements
        int xorTotal = 0;
        for (int num : arr) {
            xorTotal ^= num;
        }

        // If the total XOR is not 0, it is impossible to split into two equal XOR subsets
        if (xorTotal != 0) {
            return 0;
        }

        // Count the number of valid ways to split
        long result = 1;
        for (int i = 0; i < n - 1; i++) {
            result = (result * 2) % MOD;
        }

        return (int) result - 1; // Exclude the case where all elements are in one subset
    }
}
