public class Solution {
    public int solve(int A) {
        int maxn = 105;

        long[] dp = new long[maxn];
        int[] log_2 = new int[maxn];
        long[][] nck = new long[maxn][maxn];


        // fill the dp array with -1
        Arrays.fill(dp, -1);
        //fill the nck array with -1
        for(int i = 0; i <= A; i++) {
            Arrays.fill(nck[i], -1);
        }

        // fill the log array
        int currLog_2Ans = -1;
        int currPower2 = 1;
        for(int i = 1; i <= A; i++) {
            if(currPower2 == i) {
                currLog_2Ans++;
                currPower2 *= 2;
            }
            log_2[i] = currLog_2Ans;
        }

        return (int)getNumberOfMaxHeaps(A, dp, log_2, nck);
    }

    public static long choose(int n, int k, long[][] nck) {
        if (k > n)
            return 0;
        if (n <= 1)
            return 1;
        if (k == 0)
            return 1;

        if (nck[n][k] != -1)
            return nck[n][k];

        long MOD = 1000 * 1000 * 1000 + 7;

        long answer = choose(n - 1, k - 1, nck) + choose(n - 1, k, nck);
        answer %= MOD;
        nck[n][k] = answer;
        return answer;
    }

    public static int getL(int n, int[] log_2) {
        if (n == 1)
            return 0;

        int h = log_2[n];
        int p = n - ((1 << (h)) - 1);
        int m = (1 << h);
        if (p >= (m / 2))
            return (1 << (h)) - 1;
        else
            return (1 << (h)) - 1 - ((m / 2) - p);
    }

    public static long getNumberOfMaxHeaps(int n, long[] dp, int[] log_2, long[][] nck) {
        if (n <= 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        long MOD = 1000 * 1000 * 1000 + 7;

        int L = getL(n, log_2);
        long ans = (choose(n - 1, L, nck) * getNumberOfMaxHeaps(L, dp, log_2, nck)) % MOD * (getNumberOfMaxHeaps(n - 1 - L, dp, log_2, nck));
        ans %= MOD;
        dp[n] = ans;
        return ans;
    }
}
