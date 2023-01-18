public class Solution 
{
    public int MaxSubarraySumCircular(int[] nums) 
    {
        int len = nums.Length, total, betweenFL, withFL, resultBetweenFL, resultWithFL;
        total = betweenFL = withFL = resultBetweenFL = resultWithFL = nums[0];
        for(int i = 1; i < len; i++) 
        {
            total += nums[i];
            betweenFL = Math.Min(nums[i], nums[i] + betweenFL);
            withFL = Math.Max(nums[i], nums[i] + withFL);
            resultBetweenFL = Math.Min(resultBetweenFL, betweenFL);
            resultWithFL = Math.Max(resultWithFL, withFL);
        }
        return total != resultBetweenFL ? Math.Max(total - resultBetweenFL, resultWithFL) : resultWithFL;
    }
}