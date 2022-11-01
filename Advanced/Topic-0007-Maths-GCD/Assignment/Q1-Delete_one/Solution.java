public class Solution {
    public int solve(ArrayList<Integer> A) {
        int[] prefixGCD = new int[A.size()];
        int[] postfixGCD = new int[A.size()];

        for(int i = 0; i < A.size(); i++) {
            if(i == 0) {
                prefixGCD[i] = 0;
            } else {
                prefixGCD[i] = gcd(A.get(i - 1), prefixGCD[i - 1]);
            }
        }


        for(int i = A.size() - 1; i >= 0; i--) {
            if(i == A.size() - 1) {
                postfixGCD[i] = 0;
            } else {
                postfixGCD[i] = gcd(postfixGCD[i + 1], A.get(i + 1));
            }
        }


        int maxGCD = Integer.MIN_VALUE;

        for(int i = 0; i < A.size(); i++) {
            maxGCD = Math.max(maxGCD, gcd(prefixGCD[i], postfixGCD[i]));
        }

        return maxGCD;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }
}
