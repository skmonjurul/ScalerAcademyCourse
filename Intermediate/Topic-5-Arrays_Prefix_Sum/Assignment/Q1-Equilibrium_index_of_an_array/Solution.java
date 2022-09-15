public class Solution {
    public int solve(ArrayList<Integer> arr) {
        int sum = 0;
        for(Integer num : arr) {
            sum += num;
        }

        int leftSum = 0;
        for(int i = 0; i < arr.size(); i++) {
            int rightSum = sum - arr.get(i) - leftSum;
            if(leftSum == rightSum) return i;
            leftSum += arr.get(i);
        }

        return -1;
    }
}
