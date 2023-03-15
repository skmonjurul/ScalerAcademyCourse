public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(Integer num : arr) {
            sum += num;
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}
