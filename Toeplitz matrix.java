class Solution {
    public boolean isToeplitz(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check each element with the diagonal element
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
