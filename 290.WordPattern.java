import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        var map = new HashMap<Character, String>();
        var len = pattern.length();
        var words = s.split(" ");
        if(words.length != len) {
            return false;
        }
        var mappedSet = new HashSet<String>();
        for(int i = 0; i < pattern.length(); i++) {
            var ch = pattern.charAt(i);
            if(map.containsKey(ch)) {
                if(!map.get(ch).equals(words[i])) {
                    return false;
                }
            } else {
                if(mappedSet.contains(words[i])) {
                    return false;
                }
                map.put(ch, words[i]);
                mappedSet.add(words[i]);
            }
        }
        return true;
    }
}