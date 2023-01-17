public class Solution {
    public string LongestPalindrome(string s) {
        int start = 0, end = 0, len = s.Length;
        for(int i = 0; i < len; i++) {
            char ch = s[i];
            int left = i, right = i;
            //Get an end at left-side of our intended palindrome
            while(left >= 0) {
                if(s[left] == ch) {
                    left--;
                } else {
                    break;
                }
            }
            //Similarly, Get an end at right-side of our intended palindrome
            while(right < len) {
                if(s[right] == ch) {
                    right++;
                } else {
                    break;
                }
            }
            //We have a minimum length palindrome both using as well as surrounding the same character: s[i]
            //Now uniformly extend our palindrome on both-sides
            while(left >= 0 && right < len) {
                if(s[left] != s[right]) {
                    break;
                }
                left--;
                right++;
            }
            //Required ends are Left + 1 and Right - 1. But update only left because String-Substring usually requires like [endIndex + 1]
            left++;
            if(right - left > end - start) {
                start = left;
                end = right;
            }
        }
        return s[start..end];
    }
}