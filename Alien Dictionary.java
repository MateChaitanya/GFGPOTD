import java.util.*;

class Solution {
    public String findOrder(String[] dict, int N, int K) {
        // Step 1: Create a graph
        List<Set<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[K];
        
        // Initialize the graph
        for (int i = 0; i < K; i++) {
            graph.add(new HashSet<>());
        }
        
        // Step 2: Build the graph
        for (int i = 0; i < N - 1; ++i) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); ++j) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int u = word1.charAt(j) - 'a';
                    int v = word2.charAt(j) - 'a';
                    if (!graph.get(u).contains(v)) {
                        graph.get(u).add(v);
                        inDegree[v]++;
                    }
                    break;
                }
            }
        }
        
        // Step 3: Topological Sort using Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < K; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.append((char) (u + 'a'));
            for (int v : graph.get(u)) {
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        // If the order contains all characters, return it
        return order.length() == K ? order.toString() : "";
    }
}
