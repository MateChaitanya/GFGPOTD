import java.util.*;

class Solution {
    
    private int[] parent;
    private int[] size;
    private int n;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int MaxConnection(int[][] grid) {
        n = grid.length;
        parent = new int[n * n];
        size = new int[n * n];
        int maxConnection = 0;

        // Initialize Union-Find structure
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Union-Find to connect all initial 1's in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] direction : directions) {
                        int ni = i + direction[0];
                        int nj = j + direction[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            union(i * n + j, ni * n + nj);
                        }
                    }
                }
            }
        }

        // Find the maximum connected component in the initial grid
        for (int i = 0; i < n * n; i++) {
            if (grid[i / n][i % n] == 1) {
                maxConnection = Math.max(maxConnection, size[find(i)]);
            }
        }

        // Check each 0 cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int newSize = 1;  // We will change this cell to 1
                    for (int[] direction : directions) {
                        int ni = i + direction[0];
                        int nj = j + direction[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            int root = find(ni * n + nj);
                            if (!seen.contains(root)) {
                                newSize += size[root];
                                seen.add(root);
                            }
                        }
                    }
                    maxConnection = Math.max(maxConnection, newSize);
                }
            }
        }

        return maxConnection;
    }

    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }
}
