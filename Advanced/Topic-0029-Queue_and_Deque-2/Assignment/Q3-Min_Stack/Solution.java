class Solution {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        } else if(x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        int x = stack.pop();
        if(x == minStack.peek()) minStack.pop();
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
