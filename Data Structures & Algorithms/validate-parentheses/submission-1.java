class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(isOpeningBracket(ch)) {
                stack.push(ch);
            } else {
                if(!stack.isEmpty() && stack.peek() == getOpeningBracket(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpeningBracket(char ch) {
        if(ch == '(' || ch == '{' || ch == '[') {
            return true;
        }
        return false;
    }

    private char getOpeningBracket(char ch) {
        switch(ch) {
            case ')' : return '(';
            case '}' : return '{';
            default : return '[';
        }        
    }
}
