public class Solution 
{
    public int MinFlipsMonoIncr(string s) 
    {
        var len = s.Length;
        var result = 0;
        var flips = 0;
        for(int i = 0; i < len; i++) 
        {
            if(s[i] == '0') 
            {
                result = Math.Min(result + 1, flips);
            } 
            else 
            {
                flips++;
            }
        }
        return result;
    }
}