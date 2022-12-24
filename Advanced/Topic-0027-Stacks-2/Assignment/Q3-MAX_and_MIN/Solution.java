public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if(n == 1) return 0;
        int[] nSEL = new int[n];
        int[] nSER = new int[n];
        int[] nGEL = new int[n];
        int[] nGER = new int[n];

        Stack<Integer> stack = new Stack<>();

        //create the left nearest smaller element index array
        nearestSmallerElementsOnLeft(A, nSEL, stack);
        //create the right nearest smaller element index array
        nearestSmallerElementsOnRight(A, nSER, stack);
        //create the left nearest greater element index array
        nearestGreaterElementsOnLeft(A, nGEL, stack);
        //create the right nearest greater element index array
        nearestGreaterElementsOnRight(A, nGER, stack);

        long mod = (1000 * 1000 * 1000) + 7;
        long sum = 0;

        // for(int i = 0; i < A.size(); i++) {
        //     // find the number of subarray where current element will be maximum including itself
        //     // long maxContribution = (nGER[i] - i) * (i - (nGEL[i] + 1) + 1) * (long)A.get(i);
        //     long maxContribution = (nGER[i] - i) * (i - nGEL[i]) * (long)A.get(i);
        //     // find the number of subarray where current element will be minimum including itself
        //     // long minContribution = (nSER[i] - i) * (i - (nSEL[i] + 1) + 1) * (long)A.get(i);
        //     long minContribution = (nSER[i] - i) * (i - nSEL[i]) * (long)A.get(i);
        //     //find the difference
        //     long diff = maxContribution - minContribution;
        //     sum += diff;
        //     sum %= mod;
        // }

        for (int i = 0; i < A.size(); i++) {
            //subarray in which A[i] is min
            int p1 = nSEL[i];
            int p2 = nSER[i];
            long prodMin = (1L * (i - p1) * (p2 - i)) % mod;
            long minContribution = (prodMin * A.get(i)) % mod;

            //subarray in which A[i] is max
            int p3 = nGEL[i];
            int p4 = nGER[i];
            long prodMax = (1L * (i - p3) * (p4 - i)) % mod;
            long maxContribution = (prodMax * A.get(i)) % mod;

            //computing ans
            sum = (sum % mod) + ((maxContribution - minContribution) % mod);
            sum = sum % mod;
        }


        // for negative number we need to handle
        sum = ((sum % mod) + mod) % mod;

        return (int)sum;

    }

    public void nearestSmallerElementsOnLeft(ArrayList<Integer> A, int[] nSEL, Stack<Integer> stack) {
        //first clear the stack, we will keep index in the stack
        stack.clear();
        //for the first element there is no nearest smaller element, so index is -1
        nSEL[0] = -1;
        //put the first element index, the currene element could be nearest smaller element of next elements
        stack.push(0);

        //start from second element
        for(int i = 1; i < A.size(); i++) {
            //if current element is grater than previuosly found element
            //then nearest smaller element will be the previosly found element for the current element
            if(A.get(i) > A.get(stack.peek())){
                nSEL[i] = stack.peek();
            }
            //if current element is smaller than or equal to previosly found element
            //then start poping out untill you found smaller element or the stack is empty
            //if the stack is empty that means no smaller element found on the left side, so -1 will be the index
            else {
                while(!stack.isEmpty() && A.get(i) <= A.get(stack.peek())) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    nSEL[i] = -1;
                } else {
                    nSEL[i] = stack.peek();
                }

            }
            //current element could be the nearest element for all next elements
            stack.push(i);
        }
    }

    public void nearestSmallerElementsOnRight(ArrayList<Integer> A, int[] nSER, Stack<Integer> stack) {
        stack.clear();

        nSER[nSER.length - 1] = A.size();
        stack.push(A.size() - 1);

        for(int i = A.size() - 2; i >= 0; i--) {
            if(A.get(i) > A.get(stack.peek())) {
                nSER[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && A.get(i) <= A.get(stack.peek())) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    nSER[i] = A.size();
                } else {
                    nSER[i] = stack.peek();
                }
            }
            stack.push(i);
        }
    }

    public void nearestGreaterElementsOnLeft(ArrayList<Integer> A, int[] nGEL, Stack<Integer> stack) {
        stack.clear();

        nGEL[0] = -1;
        stack.push(0);

        for(int i = 1; i < A.size(); i++) {
            if(A.get(i) < A.get(stack.peek())){
                nGEL[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && A.get(i) >= A.get(stack.peek())) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    nGEL[i] = -1;
                } else {
                    nGEL[i] = stack.peek();
                }

            }
            stack.push(i);
        }
    }


    public void nearestGreaterElementsOnRight(ArrayList<Integer> A, int[] nGER, Stack<Integer> stack) {
        stack.clear();

        nGER[nGER.length - 1] = A.size();
        stack.push(A.size() - 1);

        for(int i = A.size() - 2; i >= 0; i--) {
            if(A.get(i) < A.get(stack.peek())) {
                nGER[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && A.get(i) >= A.get(stack.peek())) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    nGER[i] = A.size();
                } else {
                    nGER[i] = stack.peek();
                }
            }
            stack.push(i);
        }
    }
}
