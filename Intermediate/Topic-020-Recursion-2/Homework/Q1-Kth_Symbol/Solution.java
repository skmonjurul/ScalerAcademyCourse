public class Solution {
    public int solve(int A, int B) {
        return solve_v2(A, B, 0, new ArrayList<>());
    }

    public int solve_v2(int row, int index, int start, ArrayList<Integer> result) {
        if(start == 0) {
            result.add(0);
        }
        if(start == row) {
            return result.get(index - 1);
        }

        int n = (int)Math.pow(2, start - 1);
        for(int i = 0; i<n; i++) {
            if(result.get(i) == 0) {
                result.add(1);
            } else {
                result.add(0);
            }
        }

        return solve_v2(row, index, start + 1, result);

    }
}
