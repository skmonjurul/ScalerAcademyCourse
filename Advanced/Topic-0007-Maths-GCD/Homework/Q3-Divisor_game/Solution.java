public class Solution {
    public int solve(int A, int B, int C) {
        long x = A;
        long y = B;
        long z = C;

        // find the lcm of B and C;
        long lcm = (y * z) / gcd(B, C);

        // now we need to find all the multiples of lcm till A
        return (int)(x / lcm);
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }
}
