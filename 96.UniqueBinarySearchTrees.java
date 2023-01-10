class Solution {
    public int numTrees(int n) {
        var G = new int[n + 1];
        G[0] = G[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                G[i] += G[i - j] * G[j - 1];
            }
        }
        return G[n];
    }
}