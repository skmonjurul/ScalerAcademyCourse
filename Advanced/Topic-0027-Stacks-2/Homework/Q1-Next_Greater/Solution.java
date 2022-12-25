public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> nGER = new ArrayList<>();

        nGER.add(-1);
        stack.push(A.get(A.size() - 1));

        for(int i = A.size() - 2; i >= 0; i--) {
            if(A.get(i) < stack.peek()) {
                nGER.add(stack.peek());
            } else {
                while(!stack.isEmpty() && A.get(i) >= stack.peek()) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    nGER.add(-1);
                } else {
                    nGER.add(stack.peek());
                }
            }
            stack.push(A.get(i));
        }

        Collections.reverse(nGER);

        return nGER;
    }
}
