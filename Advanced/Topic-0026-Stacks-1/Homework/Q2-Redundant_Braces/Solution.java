public class Solution {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    return 1;
                } else {
                    boolean isOperatorFound = false;
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        char operator = stack.pop();
                        if(operator == '*' || operator == '/' || operator == '+' || operator == '-') {
                            isOperatorFound = true;
                        }
                    }
                    stack.pop();
                    if(!isOperatorFound) return 1;
                }
            } else {
                stack.push(ch);
            }
        }

        return 0;
    }
}
