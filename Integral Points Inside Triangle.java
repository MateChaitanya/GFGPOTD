class Solution {
    public long InternalCount(long[] p, long[] q, long[] r) {
        // Calculate the area using the determinant method
        long area = Math.abs(p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1]));

        // Calculate the number of boundary points
        long boundaryPoints = gcd(Math.abs(p[0] - q[0]), Math.abs(p[1] - q[1])) +
                              gcd(Math.abs(q[0] - r[0]), Math.abs(q[1] - r[1])) +
                              gcd(Math.abs(r[0] - p[0]), Math.abs(r[1] - p[1]));

        // Applying Pick's Theorem
        return (area - boundaryPoints) / 2 + 1;
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
