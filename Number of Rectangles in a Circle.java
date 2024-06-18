class Solution {
    public int rectanglesInCircle(int r) {
        int count = 0;

        // Iterate over all possible integer dimensions of the rectangle
        for (int length = 1; length <= 2 * r; length++) {
            for (int width = 1; width <= 2 * r; width++) {
                // Check if the rectangle can fit inside the circle
                if (Math.sqrt(length * length + width * width) <= 2 * r) {
                    count++;
                }
            }
        }

        return count;
    }
}
