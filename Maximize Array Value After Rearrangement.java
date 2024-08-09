class Solution {

    int Maximize(int arr[]) {
        // Complete the function
        int MOD = 1000000007;
        Arrays.sort(arr);
        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = (result + (long)arr[i] * i) % MOD;
        }
        return (int) result;
    }
}
