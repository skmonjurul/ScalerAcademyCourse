public class Solution {
    public String solve(String A) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> precedence = new HashMap<>();

        initializeOperatorWithPrecedence(precedence);

        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            //if ch is '*', '/', '+', '-', '^'
            if(isOperator(ch)) {
                //if stack is empty or current character has higher precedence over the top character in stack
                //then push the character
                if(stack.isEmpty() || precedence.get(stack.peek()) < precedence.get(ch)) {
                    stack.push(ch);
                } else {
                    while(!stack.isEmpty() && isOperator(stack.peek()) && precedence.get(stack.peek()) >= precedence.get(ch)) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
            //if opening bracket
            else if(ch == '(') {
                stack.push(ch);
            }
            // if closing bracket
            else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            //if operand
            else {
                result.append(ch);
            }

        }

        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public boolean isOperator(char ch) {
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    public void initializeOperatorWithPrecedence(Map<Character, Integer> precedence) {
        precedence.put('(', -1);
        precedence.put('+', 0);
        precedence.put('-', 0);
        precedence.put('/', 1);
        precedence.put('*', 1);
        precedence.put('^', 2);
    }
}
