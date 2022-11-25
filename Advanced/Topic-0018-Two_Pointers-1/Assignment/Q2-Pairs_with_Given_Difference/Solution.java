public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int left = 0, right = 1, count = 0;
        while(right < A.size()) {
            if(left == right) right++;
            if(right == A.size()) break;
            int absDiff = Math.abs(A.get(left) - A.get(right));
            if(absDiff == B) {
                count++;
                if(Objects.equals(A.get(left), A.get(right))) {
                    while (right < A.size() && Objects.equals(A.get(right), A.get(left))) right++;
                    left = right;
                    right++;
                } else {
                    left++;
                    while(left < A.size() && Objects.equals(A.get(left), A.get(left - 1))) left++;

                    right++;
                    while(right < A.size() && Objects.equals(A.get(right), A.get(right - 1))) right++;
                }
            } else if(absDiff < B) {
                right++;
            } else {
                left++;
            }

        }

        return count;
    }
}
