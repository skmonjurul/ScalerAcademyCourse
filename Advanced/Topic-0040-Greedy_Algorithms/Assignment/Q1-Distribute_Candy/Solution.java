public class Solution {
    public int candy(ArrayList<Integer> A) {
        int[] leftMax = new int[A.size()];
        int[] rightMax = new int[A.size()];

        leftMax[0] = 1;

        for(int i = 1; i < A.size(); i++) {
            if(A.get(i) > A.get(i - 1)) {
                leftMax[i] = leftMax[i - 1] + 1;
            } else {
                leftMax[i] = 1;
            }
        }

        rightMax[rightMax.length - 1] = 1;

        for(int i = A.size() - 2; i >= 0; i--) {
            if(A.get(i) > A.get(i + 1)) {
                rightMax[i] = rightMax[i + 1] + 1;
            } else {
                rightMax[i] = 1;
            }
        }


        int count = 0;
        for(int i = 0; i < A.size(); i++) {
            count += Math.max(leftMax[i], rightMax[i]);
        }

        return count;


    }
}
