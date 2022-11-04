public class Solution {
    public int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;

        for(Integer num : A) {
            max = Math.max(max, num);
        }

        int[] spf = new int[max + 1];

        sieve(spf);

        Set<Integer> distintPrime = new HashSet<>();


        for(Integer num : A) {
            if(num <= 1) continue;
            if(num == spf[num]) distintPrime.add(num);
            else {

                while(spf[num] != num) {
                    distintPrime.add(spf[num]);
                    num /= spf[num];
                }
                if(num > 1)
                    distintPrime.add(spf[num]);
            }

        }

        return distintPrime.size();
    }

    public void sieve(int[] spf) {
        for(int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }

        for(int i = 2; i * i <= spf.length - 1; i++) {
            if(spf[i] == i) {
                for(int m = i * i; m <= spf.length - 1; m += i) {
                    spf[m] = Math.min(i, spf[m]);
                }
            }
        }
    }
}
