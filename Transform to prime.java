class Solution {
    public int minNumber(int arr[], int N) {
        int sum = 0;
        int ans = 0;
        for (int n : arr) {
            sum += n;
        }
        while (!isPrime(sum)) {
            sum++;
            ans++;
        }
        return ans;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
