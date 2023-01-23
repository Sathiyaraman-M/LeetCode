class Solution {
    public int findJudge(int n, int[][] trust) {
        var in = new int[n];
        var out = new int[n];
        for(var i: trust) {
            out[i[0] - 1]++;
            in[i[1] - 1]++;
        }
        for(var i = 0; i < n; i++) {
            if(out[i] == 0 && in[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}