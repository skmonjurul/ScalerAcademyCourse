public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int minDiff = Integer.MAX_VALUE;
        int closeToSum = 1000 * 1000 * 1000;

        for(int i = 0; i < A.size(); i++) {
            int left = i + 1, right = A.size() - 1;
            while(left < right) {
                int sum = A.get(i) + A.get(left) + A.get(right);
                if(sum == B) {
                    return sum;
                }
                else if(sum < B){
                    int diff = Math.abs(B - sum);
                    if(diff < minDiff) {
                        closeToSum = sum;
                    }
                    minDiff = Math.min(minDiff, diff);
                    left++;
                } else {
                    int diff = Math.abs(B - sum);
                    if(diff < minDiff) {
                        closeToSum = sum;
                    }
                    minDiff = Math.min(minDiff, diff);
                    right--;
                }
            }
        }

        return closeToSum;
    }
}
