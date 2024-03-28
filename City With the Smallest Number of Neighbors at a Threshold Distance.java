class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        
        // Initialize the distance matrix with maximum values
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE / 2);
            distance[i][i] = 0;
        }
        
        // Update the distance matrix with edge weights
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            distance[from][to] = weight;
            distance[to][from] = weight;
        }
        
        // Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        
        int minCities = Integer.MAX_VALUE;
        int city = -1;
        
        // Iterate through all cities to find the one with the smallest number of reachable cities
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities <= minCities) {
                minCities = reachableCities;
                city = i;
            }
        }
        
        return city;
    }
}
