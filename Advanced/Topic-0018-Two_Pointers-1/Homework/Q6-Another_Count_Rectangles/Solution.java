public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int left = 0, right = A.size() - 1;
        long count = 0;
        long target = B;
        while(left < right) {
            if(A.get(left) < B && A.get(right) < B) {
                long product = (long)A.get(left) * A.get(right);
                if(product < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            } else if(A.get(left) < B) {
                right--;
            } else if(A.get(right) < B) {
                left++;
            } else {
                left++;
                right--;
            }

        }

        count *= 2;

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) < B && A.get(i) * (long)A.get(i) < B) {
                count++;
            }
        }

        return (int)(count % (1000 * 1000 * 1000 + 7));
    }
}
