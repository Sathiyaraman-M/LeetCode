class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        var N = edges.length;
        var d1 = new int[N];
        Arrays.fill(d1, Integer.MAX_VALUE);
        var d2 = new int[N];
        Arrays.fill(d2, Integer.MAX_VALUE);
        var visited1 = new boolean[N];
        var visited2 = new boolean[N];
        d1[node1] = 0;
        d2[node2] = 0;
        DFS(node1, d1, visited1, edges);
        DFS(node2, d2, visited2, edges);
        var minOfMax = Integer.MAX_VALUE;
        var result = -1;
        for(int i = 0; i < N; i++) {
            if(Math.max(d1[i], d2[i]) < minOfMax) {
                minOfMax = Math.max(d1[i], d2[i]);
                result = i;
            }
        }
        return result;
    }

    public void DFS(int curr, int dist[], boolean visited[], int edges[]) {
        visited[curr] = true;
        var next = edges[curr];
        if(next != - 1) {
            if(!visited[next]) {
                dist[next] = dist[curr] + 1;
                DFS(next, dist, visited, edges);
            }
        }
    }
}