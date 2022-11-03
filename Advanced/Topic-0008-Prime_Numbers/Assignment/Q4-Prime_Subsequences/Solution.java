public class Solution {
    public int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;

        for(Integer num : A) {
            max = Math.max(max, num);
        }

        int[] spf = new int[max + 1];

        sieve(spf);

        int count = 0;

        for(Integer num : A) {
            if(num <= 1) continue;
            if(spf[num] == num) count++;
        }

        int mod = 1000 * 1000 * 1000 + 7;
        long primeSubSequence = binaryexp(2, mod, count);

        return (int) (primeSubSequence - 1);
    }

    public long binaryexp(int A, int B, int p) {
        if(p == 0) return 1;
        long x = binaryexp(A, B, p / 2);
        long ans = (x * x) % B;

        if(p % 2 != 0) {
            ans = (ans * A) % B;
        }

        return ans;
    }

    public void sieve(int[] spf) {
        for(int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }

        for(int i = 2; i * i <= spf.length - 1; i++) {
            if(spf[i] == i) {
                for(int m = i * i; m <= spf.length - 1; m += i) {
                    spf[m] = Math.min(spf[m], i);
                }
            }
        }
    }
}
