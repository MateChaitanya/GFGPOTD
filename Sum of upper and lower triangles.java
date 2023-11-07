import java.util.ArrayList;

class Solution {
    // Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n) {
        // Create an ArrayList to store the results.
        ArrayList<Integer> list = new ArrayList<>();
        
        // Initialize variables to store the sum of upper triangle (uts) and lower triangle (lts).
        int uts = 0, lts = 0;
        
        // Iterate through the rows of the matrix.
        for (int i = 0; i < n; i++) {
            // Iterate through the columns starting from the current row index (i).
            for (int j = i; j < n; j++) {
                // Add the element at the current row (i) and column (j) to the upper triangle sum.
                uts += matrix[i][j];
                
                // Add the element at the current row (j) and column (i) to the lower triangle sum.
                lts += matrix[j][i];
            }
        }
        
        // Add the sum of the upper triangle to the ArrayList.
        list.add(uts);
        
        // Add the sum of the lower triangle to the ArrayList.
        list.add(lts);
        
        // Return the ArrayList containing the sums of upper and lower triangles.
        return list;
    }
}
