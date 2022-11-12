public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        if(B == 0 || A.size() == 0) return 0;
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= A.size() - B; i++) {
            int diff = A.get(i + B - 1) - A.get(i);
            min = Math.min(min, diff);
        }

        return min;
    }
}
