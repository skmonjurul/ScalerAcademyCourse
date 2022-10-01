public class Solution {
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (E >= C || A >= G || F >= D || B >= H) {
            return 0;
        }
        return 1;
    }
}
