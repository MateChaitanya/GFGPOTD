class Solution {
     public int isCircle(String arr[]) {
        // code here
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        int vis[] = new int[n];
        int indegree[] = new int[26];
        int outdegree[] = new int[26];
        Map<Character,ArrayList<Integer>> mm = new HashMap<>();
        for(int i=0;i<n;i++){
            mm.putIfAbsent(arr[i].charAt(0),new ArrayList<Integer>());
            mm.get(arr[i].charAt(0)).add(i);
            indegree[arr[i].charAt(0)-'a']++;
            outdegree[arr[i].charAt(arr[i].length()-1)-'a']++;
        }
        for(char x:mm.keySet()){
            if(indegree[x-'a']!=outdegree[x-'a'])return 0;
        }
        q.add(0);
        vis[0]=1;
        int ans = 1;
        while(!q.isEmpty()){
            int index = q.remove();
            char ch = arr[index].charAt(arr[index].length()-1);
            for(int x:mm.get(ch)){
                if(vis[x]==0){
                    q.add(x);
                    ans++;
                    vis[x]=1;
                }
            }
        }
        return ans==n?1:0;
    }
}
