public class Solution {
    private IList<string> result = new List<string>();
    public IList<string> GenerateParenthesis(int n) {
        Append("", n, n);
        return result;
    }

    private void Append(string curr, int left, int right) {
        if(left > right) return;
        if(left > 0) Append(curr + '(', left - 1, right);
        if(right > 0) Append(curr + ')', left, right - 1);
        if(left == 0 && right == 0) result.Add(curr);
    }
}