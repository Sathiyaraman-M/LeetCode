class Solution {
    public String longestCommonPrefix(String[] strs) {
        Character ch;
        var index = 0;
        var string = "";
        while(true) {
            if(strs[0].length() == 0 || strs[0].length() == index) {
                return string;
            }
            ch = strs[0].charAt(index);
            for(var i: strs) {
                if(i.length() == index) {
                    return string;
                }
                if(i.charAt(index) != ch) {
                    return string;
                }                
            }
            string += ch;
            index += 1;
        }
    }
}