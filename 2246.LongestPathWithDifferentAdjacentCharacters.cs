public class Solution {
    private Dictionary<int, IList<int>> graph = new Dictionary<int, IList<int>>();
    public int LongestPath(int[] parent, string str) {
        var len = parent.Length;
        for(int i = 0; i < len; i++) {
            graph[i] = new List<int>();
        }        
        for(int i = 1; i < len; i++) {
            graph[parent[i]].Add(i);
        }
        DFS(str, 0);
        return result;
    }

    private int result = 1;

    public int DFS(string str, int current) {
        if(graph[current].Count == 0) {
            return 1;
        }
        var path1 = 0;
        var path2 = 0;
        //Assume path1 > path2 always
        foreach(var node in graph[current]) {    
            var len = DFS(str, node);
            if(str[current] == str[node]) {
                continue;
            }
            if(len > path1) {
                path2 = path1;
                path1 = len;
            } else if(len > path2) {
                path2 = len;
            }
        }
        result = Math.Max(result, path1 + 1 + path2);
        return path1 + 1;
    }
}