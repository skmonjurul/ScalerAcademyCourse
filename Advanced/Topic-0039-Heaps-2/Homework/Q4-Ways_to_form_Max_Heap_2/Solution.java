public class Solution {
    public int solve(ArrayList<Integer> A) {
        int maxn = 1005;

        long[] dp = new long[maxn];
        long[] dp1 = new long[maxn];
        int[] log_2 = new int[maxn];
        long[][] nck = new long[maxn][maxn];

        int n = A.size();

        // fill the dp array with -1
        Arrays.fill(dp, -1);
        //fill the nck array with -1
        for(int i = 0; i <= n; i++) {
            Arrays.fill(nck[i], -1);
        }

        // fill the log array
        int currLog_2Ans = -1;
        int currPower2 = 1;
        for(int i = 1; i <= n; i++) {
            if(currPower2 == i) {
                currLog_2Ans++;
                currPower2 *= 2;
            }
            log_2[i] = currLog_2Ans;
        }


        int min = Integer.MAX_VALUE;
        int minCount = 0;
        int max = Integer.MIN_VALUE;
        int maxCount = 0;

        for(int i = 0; i < n; i++) {
            if(A.get(i) < min) {
                min = A.get(i);
                minCount = 1;
            } else if(A.get(i) == min) {
                minCount++;
            }

            if(A.get(i) > max) {
                max = A.get(i);
                maxCount = 1;
            } else if(A.get(i) == max) {
                maxCount++;
            }
        }

        if(maxCount == 2) {
            return (int)getNumberOfMaxHeaps(n, dp, log_2, nck);
        }

        return (int) getNumberOfMaxHeaps_2(n, dp, dp1, log_2, nck);
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

    public static long getNumberOfMaxHeaps_2(int n, long[] dp, long[] dp1, int[] log_2, long[][] nck) {
        if (n < 2)
            return (long) 0;
        if (n < 4)
            return (long) 1;
        if (n == 4)
            return (long) 2;
        if (n == 5)
            return (long) 4;
        if (dp1[n] != 0)
            return dp1[n];
        int l = getL(n, log_2);
        int r = n - l - 1;
        long MOD = 1000 * 1000 * 1000 + 7;
        long ans = (((choose(n - 3, l - 2, nck) * getNumberOfMaxHeaps_2(l, dp, dp1, log_2, nck)) % MOD) * getNumberOfMaxHeaps(r, dp, log_2, nck)) % MOD;
        ans = (ans + (((choose(n - 3, r - 2, nck) * getNumberOfMaxHeaps(l, dp, log_2, nck)) % MOD) * getNumberOfMaxHeaps_2(r, dp, dp1, log_2, nck)) % MOD) % MOD;
        ans = (ans + (((choose(n - 3, l - 1, nck) * getNumberOfMaxHeaps(l, dp, log_2, nck)) % MOD) * getNumberOfMaxHeaps(r, dp, log_2, nck)) % MOD) % MOD;
        dp1[n] = ans;
        return ans;
    }
}


// public class Solution {
//     static int maxn = 1005;
//     static long[] dp = new long[maxn];
//     static long[] dp1 = new long[maxn];
//     static long[][] nck = new long[maxn][maxn];
//     static int[] log_2 = new int[maxn];
//     static long MOD = 1000000007;



//     public int solve(int[] arr) {
//         int n = arr.length;
//         for (int i = 0; i <= n; i++)
//             dp[i] = (long) - 1;

//         for (int i = 0; i <= n; i++)
//             for (int j = 0; j <= n; j++)
//                 nck[i][j] = (long) - 1;

//         int currlog_2Answer = -1;
//         int currPower2 = 1;
//         for (int i = 1; i <= n; i++) {
//             if (currPower2 == i) {
//                 currlog_2Answer++;
//                 currPower2 *= 2;
//             }
//             log_2[i] = currlog_2Answer;
//         }
//         int max = -1;
//         int min = 10000000;
//         int maxcount = 0;
//         int mincount = 0;
//         for (int i = 0; i < n; i++) {
//             if (arr[i] < min) {
//                 min = arr[i];
//                 mincount = 1;
//             } else if (arr[i] == min) {
//                 mincount++;
//             }
//             if (arr[i] > max) {
//                 max = arr[i];
//                 maxcount = 1;
//             } else if (arr[i] == max) {
//                 maxcount++;
//             }
//         }
//         if (maxcount == 2)
//             return (int) getNumberOfMaxHeaps(n);
//         else
//             return (int) getNumberOfMaxHeaps2(n);
//     }
//     public static long choose(int n, int k) {
//         if (k > n)
//             return 0;
//         if (n <= 1)
//             return 1;
//         if (k == 0)
//             return 1;

//         if (nck[n][k] != -1)
//             return nck[n][k];
//         long answer = choose(n - 1, k - 1) + choose(n - 1, k);
//         answer %= MOD;
//         nck[n][k] = answer;
//         return answer;
//     }
//     public static int getL(int n) {
//         if (n == 1)
//             return 0;

//         int h = log_2[n];
//         int p = n - ((1 << (h)) - 1);
//         int m = (1 << h);
//         if (p >= (m / 2))
//             return (1 << (h)) - 1;
//         else
//             return (1 << (h)) - 1 - ((m / 2) - p);
//     }
//     public static long getNumberOfMaxHeaps(int n) {
//         if (n <= 1)
//             return 1;

//         if (dp[n] != -1)
//             return dp[n];

//         int L = getL(n);
//         long ans = (choose(n - 1, L) * getNumberOfMaxHeaps(L)) % MOD * (getNumberOfMaxHeaps(n - 1 - L));
//         ans %= MOD;
//         dp[n] = ans;
//         return ans;
//     }
//     public static long getNumberOfMaxHeaps2(int n) {
//         if (n < 2)
//             return (long) 0;
//         if (n < 4)
//             return (long) 1;
//         if (n == 4)
//             return (long) 2;
//         if (n == 5)
//             return (long) 4;
//         if (dp1[n] != 0)
//             return dp1[n];
//         int l = getL(n);
//         int r = n - l - 1;
//         long ans = (((choose(n - 3, l - 2) * getNumberOfMaxHeaps2(l)) % MOD) * getNumberOfMaxHeaps(r)) % MOD;
//         ans = (ans + (((choose(n - 3, r - 2) * getNumberOfMaxHeaps(l)) % MOD) * getNumberOfMaxHeaps2(r)) % MOD) % MOD;
//         ans = (ans + (((choose(n - 3, l - 1) * getNumberOfMaxHeaps(l)) % MOD) * getNumberOfMaxHeaps(r)) % MOD) % MOD;
//         dp1[n] = ans;
//         return ans;
//     }
// }

