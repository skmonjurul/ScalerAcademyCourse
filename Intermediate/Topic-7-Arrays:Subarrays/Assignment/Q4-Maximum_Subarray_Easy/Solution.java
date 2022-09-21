public class Solution {

    public int maxSubarray(int n, int b, ArrayList<Integer> arr) {
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i< n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr.get(j);
                if(sum > maxSum && sum <= b) {
                    maxSum = sum;
                }
            }
        }

        if(maxSum == Integer.MIN_VALUE) return 0;

        return maxSum;
    }
}
