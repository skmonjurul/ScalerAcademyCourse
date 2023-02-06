public class Solution {
    public int solve(int A, int B) {
        int[][] cache = new int[A + 1][B + 1];
        for(int i = 0; i <= A; i++) {
            Arrays.fill(cache[i], -1);
        }
        return nDigitNumber(A, B, false, cache);
    }

    public int nDigitNumber(int A, int B, boolean leadingZero, int[][] cache) {
        if(A == 0 && B == 0) return 1;
        if(A == 0) return 0;

        if(A == 1 && B <= 9 && B >= 0) return 1;

        if(cache[A][B] != -1) return cache[A][B];

        long number = 0;
        long mod = 1000 * 1000 * 1000 + 7;

        for(int i = 0; i <= 9; i++) {
            if(!leadingZero && i == 0) continue;
            if(i <= B)
                number += nDigitNumber(A - 1, B - i, true, cache) % mod;
            number %= mod;
        }

        cache[A][B] = (int)number;

        return (int)number;
    }
}
