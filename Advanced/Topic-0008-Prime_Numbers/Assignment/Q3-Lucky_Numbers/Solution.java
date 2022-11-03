public class Solution {
    public int solve(int A) {
        if(A <= 5) return 0;
        int[] spf = new int[A + 1];
        sieve(spf);
        int luckyNumber = 0;
        for(int i = 6; i <= A; i++) {
            if(spf[i] == 2) luckyNumber++;
        }

        return luckyNumber;

    }

    public void sieve(int[] spf) {

        for(int i = 2; i <= spf.length - 1; i++) {
            if(spf[i] == 0) {
                for(int m = i + i; m <= spf.length - 1; m += i) {
                    spf[m] = spf[m] + 1;
                }
            }
        }
    }
}
