public class Solution {
    public int findRank(String A) {

        int[] fact = new int[1001];
        fact[0] = 1;

        int mod = 1000003;

        for(int i = 1; i < fact.length; i++) {
            fact[i] = (i * fact[i - 1]) % mod;
        }

        int n = A.length();

        int rank = 0;

        for(int i = 0; i < n; i++) {
            int smallerCh = 0;
            for(int j = i + 1; j < n; j++) {
                if(A.charAt(j) < A.charAt(i)) smallerCh++;
            }

            rank += (smallerCh * fact[n - i - 1]) % mod;
        }


        return (rank + 1) % mod;
    }
}
