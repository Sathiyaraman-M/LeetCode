class Solution {
    public boolean checkInclusion(String s1, String s2) {
        var left = new int[26];
        var right = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            left[s1.charAt(i) - 'a']++;
        }
        for(int i = 0, j = 0; s1.length() + i <= s2.length() && j <= s2.length(); i++) {
            while(j < s1.length() + i) {
                right[s2.charAt(j) - 'a']++;
                j++;
            }
            if(isEqual(left, right)) return true;
            right[s2.charAt(i) - 'a']--;
        }
        return false;
    }

    private boolean isEqual(int x[], int y[]) {
        for(int i = 0; i < 26; i++)
            if(x[i] != y[i])
                return false;
        return true;
    }
}