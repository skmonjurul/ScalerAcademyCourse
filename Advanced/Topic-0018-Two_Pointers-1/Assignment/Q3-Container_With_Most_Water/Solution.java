public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        int left = 0, right = A.size() - 1;
        int maxWater = 0;

        while(left < right) {
            maxWater = Math.max(maxWater, Math.min(A.get(left), A.get(right)) * (right - left));
            if(A.get(left) < A.get(right)) left++;
            else right--;
        }

        return maxWater;

    }
}
