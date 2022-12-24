public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        ArrayList<Integer> nSLIndex = new ArrayList<Integer>();
        // ArrayList<Integer> nSRIndex = new ArrayList<Integer>();
        int[] nSRIndex = new int[A.size()];

        Stack<Integer> stack = new Stack<>();

        //create the nearest smaller element index array on left side
        nSLIndex.add(-1);
        stack.push(0);

        for(int i = 1; i < A.size(); i++) {
            if(A.get(i) > A.get(stack.peek())){
                nSLIndex.add(stack.peek());
                // stack.push(A.get(i));
            } else {
                while(!stack.isEmpty() && A.get(i) <= A.get(stack.peek())) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    nSLIndex.add(-1);
                    // stack.push(A.get(i));
                } else {
                    nSLIndex.add(stack.peek());
                }

            }
            stack.push(i);
        }

        stack.clear();

        //create the nearest smaller element index array on right side
        nSRIndex[nSRIndex.length - 1] = A.size();
        stack.push(A.size() - 1);

        for(int i = A.size() - 2; i >= 0; i--) {
            if(A.get(i) > A.get(stack.peek())) {
                nSRIndex[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && A.get(i) <= A.get(stack.peek())) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    nSRIndex[i] = A.size();
                } else {
                    nSRIndex[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        //calculate the largest area for each element
        long largestArea = Long.MIN_VALUE;
        for(int i = 0; i < A.size(); i++) {
            long distance = (nSRIndex[i] - 1) - (nSLIndex.get(i) + 1) + 1;
            long area = distance * A.get(i);
            largestArea = Math.max(largestArea, area);

        }

        return (int)largestArea;



    }
}
