public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;  i < B; i++) {
            stack.push(A.get(i));
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        for(int i = B; i < A.size(); i++) {
            result.add(A.get(i));
        }

        return result;
    }
}
