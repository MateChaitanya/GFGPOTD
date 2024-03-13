class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] diagonalArray = new int[n * n];
        int index = 0;

        // Start from the top-left corner
        int row = 0, col = 0;

        // Iterate through the entire matrix
        for (int i = 0; i < n * n; i++) {
            diagonalArray[index++] = mat[row][col];

            // Move to the next element in the diagonal pattern
            if ((row + col) % 2 == 0) { // Move up
                if (col == n - 1) { // If at the last column, move down
                    row++;
                } else if (row == 0) { // If at the first row, move right
                    col++;
                } else { // Otherwise, move up-right
                    row--;
                    col++;
                }
            } else { // Move down
                if (row == n - 1) { // If at the last row, move right
                    col++;
                } else if (col == 0) { // If at the first column, move down
                    row++;
                } else { // Otherwise, move down-left
                    row++;
                    col--;
                }
            }
        }

        return diagonalArray;
    }
}
