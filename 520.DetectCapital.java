class Solution {
    public boolean detectCapitalUse(String word) {
        var len = word.length();
        var case1 = true;
        var case2 = true;
        var case3 = Character.isUpperCase(word.charAt(0));
        for(int i = 0; i < len; i++) {            
            if(Character.isUpperCase(word.charAt(i))) {
                case2 = false;
                if(case3 && i != 0) {
                    case3 = false;
                }
            } else {
                case1 = false;
            }
        }
        System.out.println(case1);
        System.out.println(case2);
        System.out.print(case3);
        return case1 || case2 || case3;
    }
}