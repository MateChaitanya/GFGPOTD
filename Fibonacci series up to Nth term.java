class Solution {
    int MOD = 1000000007;

    int[] Series(int n) {
        int[] fibSeries = new int[n + 1];
        fibSeries[0] = 0;
        if (n > 0) {
            fibSeries[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibSeries[i] = (fibSeries[i - 1] + fibSeries[i - 2]) % MOD;
            }
        }
        return fibSeries;
    }
}
