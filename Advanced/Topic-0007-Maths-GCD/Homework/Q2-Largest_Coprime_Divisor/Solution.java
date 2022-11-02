public class Solution {
    public int cpFact(int A, int B) {
        int g = gcd(A, B);

        // keep deviding the A with gcd(A, B) untill we get gcd(A, B) = 1
        while(g != 1) {
            A /= g;
            g = gcd(A, B);
        }

        return A;

    }

    public int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }
}
