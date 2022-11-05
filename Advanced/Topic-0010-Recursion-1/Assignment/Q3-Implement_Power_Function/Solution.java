public class Solution {
    public int pow(int A, int B, int C) {
        if(A == 0) return 0;
        if(B == 0) return 1;
        long ans = 1;
        long x = A;
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
        return (int) ans;
    }
}
