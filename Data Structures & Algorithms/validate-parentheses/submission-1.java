class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (
                    (top == '(' && ch == ')') ||
                    (top == '[' && ch == ']') ||
                    (top == '{' && ch == '}')
                ) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }

        return stack.isEmpty();
    }
}
