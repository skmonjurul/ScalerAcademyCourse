public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) < 0) continue;
            if(A.get(i) == A.size() - i - 1 && (i + 1 == A.size() || (i < A.size() && A.get(i + 1) > A.get(i)))) return 1;
        }

        return -1;
    }
}
