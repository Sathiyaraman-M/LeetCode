class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        var len = s.length();
        var sublen = p.length();
        var result = new ArrayList<Integer>();
        if(len < sublen) return result;
        var original = getCounter(p);
        var slider = getCounter(s.substring(0, sublen));
        if(Arrays.equals(original, slider)) {
            result.add(0);
        }
        for(int i = sublen; i < len; i++) {
            slider[s.charAt(i - sublen) - 'a']--;
            slider[s.charAt(i) - 'a']++;
            if(Arrays.equals(original, slider)) {
                result.add(i - sublen + 1);
            }
        }
        return result;
    }

    private static int[] getCounter(String s) {
        var arr = new int[26];
        for(var ch: s.toCharArray()) {
            arr[ch - 'a']++;
        }
        return arr;
    }
}