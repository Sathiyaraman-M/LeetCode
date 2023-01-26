public class Solution {
    public int FindCheapestPrice(int n, int[][] flights, int src, int dst, int k) {        
        var dist = new int[n];
        Array.Fill(dist, int.MaxValue);
        dist[src] = 0;
        for(int i = 0; i <= k; i++) {
            var temp = dist.ToArray();
            foreach(var flight in flights) {
                if(dist[flight[0]] != int.MaxValue) {
                    temp[flight[1]] = Math.Min(dist[flight[0]] + flight[2], temp[flight[1]]);
                }
            }
            dist = temp;
        }
        return dist[dst] != int.MaxValue ? dist[dst] : -1;
    }
}