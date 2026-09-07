class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            char ch = tokens[i].charAt(0);
            if (!(Character.isDigit(ch) || tokens[i].length() > 1)) {
                int sec = stack.pop();
                int first = stack.pop();
                
                if (ch == '/') {
                    stack.push(first / sec);
                }
                else if (ch == '+') {
                    stack.push(first + sec);
                }
                else if (ch == '*') {
                    stack.push(first * sec);
                }
                else {
                    stack.push(first - sec);
                }
            }
            else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();

    }
}
