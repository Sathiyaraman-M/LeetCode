class Solution {
    int result;
    int[] parent, count;

    private int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    private void union(int x, int y, int[] vals) {
        int parx = find(x);
        int pary = find(y);
        if(parx == pary) 
            return;
        if(vals[parx] == vals[pary]) {
            result += count[parx] * count[pary];
            count[parx] += count[pary];
            parent[pary] = parx;
        } else if(vals[parx] > vals[pary]) {
            parent[pary] = parx;
        } else {
            parent[parx] = pary;
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Arrays.sort(edges, (x, y) -> Integer.compare(Math.max(vals[x[0]], vals[x[1]]), Math.max(vals[y[0]], vals[y[1]])));       
        int n = vals.length;      
        result = n; 
        parent = new int[n];
        count = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            count[i] = 1;
        }
        
        for(int[] edge: edges) {
            union(edge[0], edge[1], vals);
        }

        return result;
    } 
}