class Solution {
    public int findCoverage(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalCoverage = 0;

        // Directions arrays to move in left, right, up, and down directions
        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    int coverage = 0;
                    // Check all four directions
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + dRow[k];
                        int newCol = j + dCol[k];
                        // Check if the new position is within bounds and is a 1
                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] == 1) {
                            coverage++;
                        }
                    }
                    totalCoverage += coverage;
                }
            }
        }

        return totalCoverage;
    }
}
