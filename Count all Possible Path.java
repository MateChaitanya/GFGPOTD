import java.util.*;

class Solution
{
    public int isPossible(int[][] paths)
    {
        int n = paths.length;
        
        // Check if the graph is connected
        if (!isConnected(paths, n))
            return 0;
        
        // Check if each vertex has an even degree
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += paths[i][j];
            }
            if (degree % 2 != 0)
                return 0;
        }
        
        return 1;
    }
    
    // Function to check if the graph is connected using DFS
    private boolean isConnected(int[][] paths, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        dfs(paths, 0, visited);
        for (int i = 0; i < n; i++) {
            if (visited[i])
                count++;
        }
        return count == n;
    }
    
    // DFS traversal
    private void dfs(int[][] paths, int v, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < paths.length; i++) {
            if (paths[v][i] == 1 && !visited[i]) {
                dfs(paths, i, visited);
            }
        }
    }
}
