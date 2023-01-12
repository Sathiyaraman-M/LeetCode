class Solution {
  int [] result;
  List<List<Integer>> adj;
  boolean[] visited;
   public int[] countSubTrees(int n, int[][] edges, String labels) {
     adj = new ArrayList<>(n);
     result = new int[n];
    for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());
    }
    for(int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }
     visited = new boolean[n];
    dfs(0,labels);
    return result;
}
int[] dfs(int node, String labels){
    visited[node] = true;
    int[] count = new int[26];
    for(int nbr : adj.get(node)){
        if(!visited[nbr]){
            int [] adjCount = dfs(nbr, labels);
            for(int i = 0 ; i < 26; i++){
                count[i] += adjCount[i];
            }
        }
    }
    char ch = labels.charAt(node);
    count[ch-'a']++;
    result[node] = count[ch-'a'];
    return count;
  }
}