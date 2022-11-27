public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int a = 0, b = 0, c = 0;
        int minDiff = Integer.MAX_VALUE;

        while(a < A.size() && b < B.size() && c < C.size()) {
            int max = Math.max(A.get(a), Math.max(B.get(b), C.get(c)));
            int min = Math.min(A.get(a), Math.min(B.get(b), C.get(c)));
            int diff = Math.abs(max - min);
            minDiff = Math.min(minDiff, diff);

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
