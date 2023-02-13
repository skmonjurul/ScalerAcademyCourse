public class Solution {
    public int chordCnt(int A) {
        long[] noOfWay = new long[A + 1];
        noOfWay[0] = 1;
        noOfWay[1] = 1;

        long mod = 1000 * 1000 * 1000 + 7;

        for(int i = 2; i <= A; i++) {
            for(int j = 0; j < i; j++) {
                // noOfWay[i] += ( (noOfWay[j] % mod) * (noOfWay[i - j - 1] % mod)  % mod );
                noOfWay[i] += (noOfWay[j] % mod) * (noOfWay[i - j - 1] % mod);
                noOfWay[i] %= mod;
            }
        }

        return (int)noOfWay[A];
    }
}
