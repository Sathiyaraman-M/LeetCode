public class Solution 
{
    public int[][] Insert(int[][] intervals, int[] newInterval) 
    {
        var len = intervals.Count();
        var list = new List<int[]>();
        for(int i = 0; i < len; i++) 
        {
            if(intervals[i][1] < newInterval[0]) 
            { 
                // with [(a, b), (c, d)] and b < c -> (c, d) is latest interval
                list.Add(intervals[i]);
            } 
            else if(intervals[i][0] > newInterval[1]) 
            { 
                // with [(a, b), (c, d)] and d > a -> (a, b) is latest interval
                list.Add(newInterval);
                newInterval = intervals[i];
            } 
            else 
            { 
                // Overlapping So merge
                newInterval[0] = Math.Min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.Max(newInterval[1], intervals[i][1]);
            }
        }
        list.Add(newInterval);
        return list.ToArray();
    }
}