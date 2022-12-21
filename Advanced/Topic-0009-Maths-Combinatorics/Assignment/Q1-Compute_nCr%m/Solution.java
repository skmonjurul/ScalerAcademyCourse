public class Solution {
    public int solve(int A, int B, int C) {
        int n = A;
        int r = B;
        int m = C;
        int[][] dp = new int[n + 1][r + 1];


        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= Math.min(i, r); j++) {
                if(j == 0 || j == i) {
                    dp[i][j] = 1;
                }

                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    dp[i][j] %= m;
                }
            }
        }

        return dp[n][r];
    }
}
