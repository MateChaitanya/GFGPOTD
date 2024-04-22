class Solution {
    public int minRow(int n, int m, int[][] a) {
        int minRowIndex = 1; 
        int minOnes = Integer.MAX_VALUE; 

        for (int i = 0; i < n; i++) {
            int count = 0;
           
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    count++;
                }
            }

            if (count < minOnes) {
                minOnes = count;
                minRowIndex = i + 1; 
            }
        }

        return minRowIndex;
    }
}
