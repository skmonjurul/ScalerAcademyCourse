public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int a = 0, b = 0, c = 0;
        int minDiff = Integer.MAX_VALUE;

        while(a < A.size() && b < B.size() && c < C.size()) {
            int ab_diff = Math.abs(A.get(a) - B.get(b));
            int bc_diff = Math.abs(B.get(b) - C.get(c));
            int ac_diff = Math.abs(A.get(a) - C.get(c));


            int max = Math.max(ab_diff, Math.max(bc_diff, ac_diff));
            minDiff = Math.min(minDiff, max);

            if(A.get(a) <= B.get(b) && A.get(a) <= C.get(c)) {
                a++;
            } else if(B.get(b) <= A.get(a) && B.get(b) <= C.get(c)) {
                b++;
            } else if(C.get(c) <= A.get(a) && C.get(c) <= B.get(b)) {
                c++;
            }

        }

        return minDiff;
    }
}
