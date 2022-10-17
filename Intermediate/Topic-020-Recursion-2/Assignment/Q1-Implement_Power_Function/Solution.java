public class Solution {
    public int pow(int A, int B, int C) {
        if(A == 0) return 0;
        if(B == 0) return 1;
        long x = A;
        long result = 1L;
        while(B > 0) {
            if(B % 2 == 1){
                result = result * x;
                result = result % C;
            }
            x *= x;
            x = x % C;
            B = B >> 1;
        }
        return (int)(result + C) % C;
    }
}
