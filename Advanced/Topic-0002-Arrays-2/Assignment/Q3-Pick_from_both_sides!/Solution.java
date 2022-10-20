public class Solution {
    public int solve(ArrayList<Integer> arr, int B) {
        int max = Integer.MIN_VALUE;
        int totalFrontSum = 0;
        for(int i = 0; i < B; i++) {
            totalFrontSum += arr.get(i);
        }

        max = Math.max(max, totalFrontSum + 0);
        int leftSum = 0, rightSum = 0;
        for(int i = B - 1; i >= 0; i--) {
            leftSum += arr.get(i);
            int left = totalFrontSum - leftSum;
            int endIndex = arr.size() - (B - i);
            rightSum = arr.get(endIndex) + rightSum;
            max = Math.max(max, left + rightSum);
        }

        return max;
    }
}
