public class Solution {
    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if(ch == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return 0;
            } else if(ch == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return 0;
            } else if(ch == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return 0;
            }
        }


        return stack.isEmpty() ? 1 : 0;
    }
}
