public class Solution {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();

        for(String str : A) {
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(evaluate(a, b, str));
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }

    public int evaluate(int a, int b, String operator) {
        if(operator.equals("*")) return a * b;
        if(operator.equals("/")) return a / b;
        if(operator.equals("+")) return a + b;
        if(operator.equals("-")) return a - b;

        return 0;
    }
}
