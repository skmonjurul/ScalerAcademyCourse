public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        result.add(-1);
        stack.push(A.get(0));

        for(int i = 1; i < A.size(); i++) {
            if(A.get(i) > stack.peek()){
                result.add(stack.peek());
                // stack.push(A.get(i));
            } else {
                while(!stack.isEmpty() && A.get(i) <= stack.peek()) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    result.add(-1);
                    // stack.push(A.get(i));
                } else {
                    result.add(stack.peek());
                }

            }
            stack.push(A.get(i));
        }

        return result;
    }
}
