class Solution {
    static String armstrongNumber(int n) {
        int originalNumber = n;
        int sumOfCubes = 0;

        while (n > 0) {
            int digit = n % 10;
            sumOfCubes += digit * digit * digit;
            n /= 10;
        }

        if (sumOfCubes == originalNumber) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
