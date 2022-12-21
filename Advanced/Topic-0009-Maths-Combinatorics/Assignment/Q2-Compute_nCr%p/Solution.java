public class Solution {
    public int solve(int A, int B, int C) {
        int n = A;
        int r = B;
        int p = C;


        long[] fact = new long[n + 1];

        fact[0] = 1;
        for(int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % p;
        }

        long ans = fact[n];
        ans = (ans * binexp(fact[r], p - 2, p)) % p;
        ans = (ans * binexp(fact[n - r], p - 2, p)) % p;

        return (int)ans;
    }

    public long binexp(long a, int b, int m) {
        if(b == 0 || a == 1) return 1;

        long res = 1;

        while(b > 0) {
            if((b & 1) == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            b = b >> 1;
        }

        return res;
    }
}
