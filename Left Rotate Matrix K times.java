class Solution {
    int[][] rotateMatrix(int k, int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];

        // To reduce the number of rotations
        k = k % cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Calculate new position after rotation
                int newPos = (j + cols - k) % cols;
                result[i][newPos] = mat[i][j];
            }
        }

        return result;
    }
}
