public class Solution {
    public String solve(String A) {
        Stack<Character> stack = new Stack();



        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else if(stack.peek() == ch) {
                stack.pop();
            }
        }


        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
