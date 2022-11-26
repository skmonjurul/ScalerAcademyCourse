public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int left = 0, right = A.size() - 1, count = 0;

        while(left < right) {
            int sum = A.get(left) + A.get(right);
            if(sum == B) {
                count++;
                left++;
                right--;
            } else if(sum < B) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
