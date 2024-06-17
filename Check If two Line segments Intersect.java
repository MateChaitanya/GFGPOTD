class Solution {
    // Function to check if point q lies on line segment pr
    public boolean func(int[] p, int[] q, int[] r) {
        if (q[0] <= Math.max(p[0], r[0]) && q[0] >= Math.min(p[0], r[0]) && q[1] <= Math.max(p[1], r[1]) && q[1] >= Math.min(p[1], r[1])) {
            return true;
        }
        return false;
    }

    // Function to find the orientation of the ordered triplet (p, q, r)
    public int direction(int[] p, int[] q, int[] r) {
        long val = 1L * (q[1] - p[1]) * (r[0] - q[0]) - 1L * (q[0] - p[0]) * (r[1] - q[1]);

        if (val == 0) return 0; // collinear
        return (val > 0) ? 1 : -1; // clock or counterclock wise
    }

    // Main function to check if the line segments (p1, q1) and (p2, q2) intersect
    public String doIntersect(int[] p1, int[] q1, int[] p2, int[] q2) {
        int o1 = direction(p1, q1, p2);
        int o2 = direction(p1, q1, q2);
        int o3 = direction(p2, q2, p1);
        int o4 = direction(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4) {
            return "true";
        }

        // Special Cases
        if (o1 == 0 && func(p1, p2, q1)) {
            return "true";
        }
        if (o2 == 0 && func(p1, q2, q1)) {
            return "true";
        }
        if (o3 == 0 && func(p2, p1, q2)) {
            return "true";
        }
        if (o4 == 0 && func(p2, q1, q2)) {
            return "true";
        }

        // Doesn't fall in any of the above cases
        return "false";
    }
}
