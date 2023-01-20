public class Solution 
{    
    public IList<IList<int>> FindSubsequences(int[] nums) 
    {
        return Generate(new List<int>(), 0, nums);
    }

    private IList<IList<int>> Generate(List<int> list, int index, int[] nums) 
    {
        var result = new List<IList<int>>();
        var used = new HashSet<int>();
        for(int i = index; i < nums.Length; i++) 
        {
            if(i != index && used.Contains(nums[i])) 
                continue;
            if(index == 0 || nums[i] >= list.Last()) 
            {
                list.Add(nums[i]);
                if(list.Count > 1) 
                {
                    result.Add(list.ToList());
                }
                result.AddRange(Generate(list, i + 1, nums));
                list.RemoveAt(list.Count - 1);
            }
            used.Add(nums[i]);
        }
        return result;
    }
}