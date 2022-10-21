public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int sum = 0;

        int[] postfixMax = new int[A.size()];
        int maxRight = Integer.MIN_VALUE;

        for(int i = A.size() - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, A.get(i));
            postfixMax[i] = maxRight;
        }

        int maxLeft = Integer.MIN_VALUE;
        maxLeft = Math.max(maxLeft, A.get(0));
        for(int i = 1; i < A.size(); i++) {
            maxLeft = Math.max(maxLeft, A.get(i));
            maxRight = postfixMax[i];
            sum += Math.min(maxLeft, maxRight) - A.get(i);
        }

        return sum;
    }
}
