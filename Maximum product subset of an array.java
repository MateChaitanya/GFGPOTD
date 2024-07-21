import java.util.List;

class Solution {
    public long findMaxProduct(List<Integer> arr) {
        int mod = 1000000007;
        if (arr.size() == 1) {
            return arr.get(0) % mod;
        }

        long maxProduct = 1;
        int negativeCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE;
        int minPositive = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            } else {
                if (num < 0) {
                    negativeCount++;
                    maxNegative = Math.max(maxNegative, num);
                } else {
                    minPositive = Math.min(minPositive, num);
                }
                maxProduct = (maxProduct * num) % mod;
            }
        }

        // If all elements are zero
        if (zeroCount == arr.size()) {
            return 0;
        }

        // If there's only one negative number and all others are zeros
        if (negativeCount == 1 && zeroCount + 1 == arr.size()) {
            return 0;
        }

        // If the count of negative numbers is odd, exclude the maximum negative number
        if (negativeCount % 2 != 0) {
            maxProduct = maxProduct / maxNegative;
        }

        return (maxProduct + mod) % mod; // Ensure positive result
    }
}
