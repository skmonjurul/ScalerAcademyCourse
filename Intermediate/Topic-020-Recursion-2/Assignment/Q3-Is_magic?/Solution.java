public class Solution {
    public int solve(int A) {
        int sum = 0;
        while(A > 0) {
            int d = A % 10;
            sum += d;
            A = A / 10;
        }
        if(sum < 10 && sum == 1) {
            return 1;
        } else if(sum < 10) {
            return 0;
        }

        return solve(sum);
    }

    public int solve_v2(int A) {
        if(A % 9 == 1) return 1;
        return 0;
    }
}
