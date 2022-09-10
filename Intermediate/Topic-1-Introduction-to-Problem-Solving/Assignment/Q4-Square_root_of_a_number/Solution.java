public class Solution {
    public int solve(int n) {
        for(int i = 1; i * i <= n; i++) {
            if(i * i == n) return i;
        }

        return -1;
    }
}
