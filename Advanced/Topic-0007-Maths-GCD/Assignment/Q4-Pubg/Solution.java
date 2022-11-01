public class Solution {
    public int solve(ArrayList<Integer> A) {
        int g = 0;

        for(int i = 0; i < A.size(); i++) {
            g = gcd(g, A.get(i));
        }

        return g;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
