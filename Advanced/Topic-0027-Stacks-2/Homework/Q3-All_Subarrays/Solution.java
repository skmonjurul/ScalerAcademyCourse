public class Solution {
    public int solve(ArrayList<Integer> A) {
        if(A == null || A.size() == 1) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(A.get(0));

        int max = Integer.MIN_VALUE;

        for(int i = 1; i < A.size(); i++) {
            if(A.get(i) >= stack.peek()) {
                while(!stack.isEmpty() && A.get(i) >= stack.peek()) {
                    int xor = A.get(i) ^ stack.pop();
                    max = Math.max(max, xor);
                }
                if(!stack.isEmpty()) {
                    int xor = A.get(i) ^ stack.peek();
                    max = Math.max(max, xor);
                }
                stack.push(A.get(i));
            } else {
                int xor = stack.peek() ^ A.get(i);
                max = Math.max(max, xor);
                stack.push(A.get(i));
            }
        }

        return max;


    }
}
