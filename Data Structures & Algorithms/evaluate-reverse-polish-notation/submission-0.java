class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int res = compute(a, b, token);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    private boolean isOperator(String ch) {
        return switch(ch) {
            case "+","-","*","/" -> true;
            default -> false;
        };
    }

    private int compute(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
