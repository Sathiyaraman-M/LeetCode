class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        var len = s.length();
        for(int i = 0; i < len; i++) {
            var ch = s.charAt(i);
            switch(ch) {
                case '(':
                    stack.push(ch);
                    break;
                case '[':
                    stack.push(ch);
                    break;
                case '{':
                    stack.push(ch);
                    break;
                default:
                    if(stack.size() == 0) return false;
                    var out = stack.pop();
                    switch(out) {
                        case '(':
                            if (ch != ')') return false;
                            break;
                        case '[':
                            if (ch != ']') return false;
                            break;
                        case '{':
                            if (ch != '}') return false;
                            break;
                    }
                    break;
            }
        }
        return stack.size() == 0;
    }
}