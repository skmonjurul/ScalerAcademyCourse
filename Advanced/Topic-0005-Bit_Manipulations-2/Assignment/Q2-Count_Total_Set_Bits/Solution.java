public class Solution {
    public int solve(int A) {
        long n = A;

        int bits = 0;
        while(n > 0) {
            bits++;
            n = n >> 1;
        }

        n = A;

        long total = 0;
        for(long i = bits - 1; i >= 0; i--) {
            if(isSetBit((int)n, (int)i)) {
                total += (i * (1L << i - 1)) + (n - (1L << i) + 1);
                n = n - (1L << i);
            }
        }

        return (int)(total % (Math.pow(10, 9) + 7));
    }
    public boolean isSetBit(int num, int k) {
        return (num & (1 << k)) != 0;
    }
}
