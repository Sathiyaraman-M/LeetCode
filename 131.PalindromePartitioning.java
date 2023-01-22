class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, s, 0);
        return ans;
    }
    
    private void backtrack(List<String> candidates, List<List<String>> ans, String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(candidates));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String candidate = s.substring(start, i + 1);
            if (!isPalindrome(candidate)) continue;
            candidates.add(candidate);
            backtrack(candidates, ans, s, i + 1);
            candidates.remove(candidates.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}