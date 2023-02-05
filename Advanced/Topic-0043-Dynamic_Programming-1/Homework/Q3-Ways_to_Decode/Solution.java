public class Solution {
    public int numDecodings(String A) {
        if(A.charAt(0) == '0') return 0;

        long[] cache = new long[A.length()];

        int n = A.length();

        if(A.charAt(n - 1) != '0') {
            cache[n - 1] = 1L;
        }
        else {
            if(A.charAt(n - 2) == '0') return 0;
            if(A.charAt(n - 2) >= '3') return 0;
            cache[n - 1] = 0L;
        }

        int mod = 1000 * 1000 * 1000 + 7;

        for(int i = n - 2; i >= 0; i--) {
            if(A.charAt(i) == '0' && (A.charAt(i - 1) == '0' || A.charAt(i - 1) >= '3')) return 0;
            if(A.charAt(i) == '0') continue;
            int number = Integer.parseInt(A.substring(i, i + 2));
            if(number > 26) {
                cache[i] = cache[i + 1];
            } else {
                if(i + 2 < n)
                    cache[i] = (cache[i + 1] % mod + cache[i + 2] % mod) % mod;
                else
                    cache[i] = (cache[i + 1] % mod + 1) % mod;
            }
        }

        return (int)cache[0];
    }
}
