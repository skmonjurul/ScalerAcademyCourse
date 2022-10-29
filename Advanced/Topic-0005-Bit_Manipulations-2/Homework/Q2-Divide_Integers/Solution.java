public class Solution {
    public int divide(int A, int B) {
        int sign = 1;
        if(A < 0) {
            sign = -sign;
        }
        if(B < 0) {
            sign = -sign;
        }

        long n = A, m = B;
        n = Math.abs(n);
        m = Math.abs(m);

        long q = 0;
        for(int i = 31; i >= 0; i--) {
            long x = m << i;
            if(x <= n) {
                n -= x;
                q += 1L << i;
            }
        }

        if(sign < 0) {
            q = -q;
        }

        if(q > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) q;

    }
}
