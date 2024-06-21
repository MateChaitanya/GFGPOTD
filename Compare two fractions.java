class Solution {
    String compareFrac(String str) {
        // Split the string by ", "
        String[] fractions = str.split(", ");
        
        // Split each fraction by "/"
        String[] fraction1 = fractions[0].split("/");
        String[] fraction2 = fractions[1].split("/");
        
        // Parse the numerator and denominator of each fraction
        int a = Integer.parseInt(fraction1[0]);
        int b = Integer.parseInt(fraction1[1]);
        int c = Integer.parseInt(fraction2[0]);
        int d = Integer.parseInt(fraction2[1]);
        
        // Cross multiply to compare without using floating-point arithmetic
        long lhs = (long) a * d; // a/b compared to c/d as a*d
        long rhs = (long) c * b; // a/b compared to c/d as c*b
        
        if (lhs > rhs) {
            return fractions[0]; // a/b is greater
        } else if (lhs < rhs) {
            return fractions[1]; // c/d is greater
        } else {
            return "equal"; // Both are equal
        }
    }
}
