public class Solution 
{
    public int Reverse(int x) 
    {
        try 
        {
            if (x == 0) return 0;
            var val = Math.Abs(x);
            var sign = x / val;
            var rev = string.Join("", val.ToString().Select(x => x).Reverse());
            var result = sign * int.Parse(rev);
            return result;
        } 
        catch (Exception ex) 
        {
            return 0;
        }
    }
}