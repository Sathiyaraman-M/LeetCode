public class Solution {
    public IList<string> RestoreIpAddresses(string s) {
        var result = new List<string>();
        var address = new List<string>();
        GenerateAddresses(s, address, result, 0);
        return result;
    }

    public void GenerateAddresses(string s, List<string> address, List<string> result, int index)
    {
        if(address.Count == 4) {
            if(index == s.Length) {
                result.Add(string.Join(".", address));
                address = new List<string>();    
            }
        } else {
            for(int j = index + 1; j <= index + 3 && j <= s.Length; j++) {
                var next = s[index..j];
                if(int.Parse(next) <= 255 && (next == "0" || !next.StartsWith('0'))) {
                    address.Add(next);
                    GenerateAddresses(s, address, result, j);
                    address.RemoveAt(address.Count - 1);
                }
            }
        }
    }
}