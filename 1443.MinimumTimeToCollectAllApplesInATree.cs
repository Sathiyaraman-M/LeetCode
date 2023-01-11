public class Solution 
{
    public int MinTime(int n, int[][] edges, IList<bool> hasApple) 
    {
        var dict = new Dictionary<int, IList<int>>();
        for(int i = 0; i < n; i++) 
        {
            dict[i] = new List<int>();
        }
        foreach(var edge in edges) 
        {
            dict[edge[0]].Add(edge[1]);
            dict[edge[1]].Add(edge[0]);
        }
        return Math.Max(DFS(dict, hasApple, -1, 0) - 1, 0);
    }

    public int DFS(Dictionary<int, IList<int>> nodes, IList<bool> hasApple, int parent, int current) 
    {
        var cost = 0;
        foreach(var node in nodes[current]) 
        {
            if(node == parent)
                continue;
            var subCost = DFS(nodes, hasApple, current, node);
            if(subCost != 0) 
            {
                cost += subCost + 1;
            }
        }
        return (!hasApple[current] && cost == 0) ? 0 : cost + 1;
    }
}