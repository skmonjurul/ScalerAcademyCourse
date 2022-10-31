public class Solution {
    public int solve(int A, int B) {
        if(A == 0) return 0;
        long mod = 1000 * 1000 * 1000 + 7;
        if(B == 0 || B == 1) return (int)(((A % mod) + mod) % mod);

        long fact = 1;
        for(int i = 2; i <= B; i++) {
            //using fermat's little theorem
            fact = (fact * i) % (mod - 1);
        }

        return (int)pow(A, fact, mod);


        // long x = A;
        // for(int i = B; i >= 1; i--) {
        //     x = pow(x, i, mod);
        // }

        // return (int)x;
    }

    public long pow(long x, long B, long C) {
        if(x == 0) return 0;
        if(B == 0) return 1;

        // long x = A;
        long ans = 1L;
        while(B > 0) {
            if(B % 2 != 0) {
                ans = ans * x;
                ans = ans % C;
            }
            x = x * x;
            x = x % C;
            B = B >> 1;
        }

        ans = (ans + C) % C;
        return ans;
    }
}
