
@ajinkyajain2302
12 hours ago (edited)
JAVA Code : 

public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; ++i){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        dis[src] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nbr : adj.get(cur)){
                if(dis[cur] + 1 < dis[nbr]){
                    dis[nbr] = dis[cur] + 1;
                    q.add(nbr);
                }
            }
        }
        
        for(int i = 0; i < n; ++i){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
    }
