public class Solution {
    public int solve(int A, int B) {
        long ans = binaryexp(A, B, B - 2);
        return (int) ans;
    }

    public long binaryexp(int A, int B, int p) {
        if(p == 0) return 1;
        long x = binaryexp(A, B, p / 2);
        long ans = (x * x) % B;

        if(p % 2 != 0) {
            ans = (ans * A) % B;
        }

        return ans;
    }
}
