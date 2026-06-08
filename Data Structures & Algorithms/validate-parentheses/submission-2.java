class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> close = new HashMap<>();
        close.put(')', '(');
        close.put('}', '{');
        close.put(']', '[');

        for(char ch : s.toCharArray()) {
            if(close.containsKey(ch)) {
                if(!stack.isEmpty() && stack.peek() == close.get(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
