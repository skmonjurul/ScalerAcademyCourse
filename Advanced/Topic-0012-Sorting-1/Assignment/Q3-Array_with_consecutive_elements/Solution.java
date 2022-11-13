public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i = 0; i < A.size() - 1; i++) {
            if(A.get(i) + 1 != A.get(i + 1)) return 0;
        }

        return 1;
    }
}
