public class Solution {
    private int[] arr = new int[26];
    
    private int GetRoot(int ch) {
        return (ch == arr[ch]) ? ch : (arr[ch] = GetRoot(arr[ch]));
    }

    private void Link(int ch1, int ch2) {
        ch1 = GetRoot(ch1);
        ch2 = GetRoot(ch2);
        if(ch1 != ch2) {
            if(ch1 < ch2) arr[ch2] = ch1;
            else arr[ch1] = ch2;
        }
    }

    public string SmallestEquivalentString(string s1, string s2, string baseStr) {
        var len = s1.Length;        
        for(int i = 0; i < 26; i++) {
            arr[i] = i;
        }
        for(int i = 0; i < len; i++) {
            Link(s1[i] - 'a', s2[i] - 'a');
        }
        var str = "";
        for(int i = 0; i < baseStr.Length; i++) {
            str += (char)(GetRoot(baseStr[i] - 'a') + 'a');
        }
        return str;
    }
}