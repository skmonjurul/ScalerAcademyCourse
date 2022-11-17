public class Solution {
    public int solve(ArrayList<Integer> A) {
        int pow = 1000 * 1000 * 1000 + 7;
        Collections.sort(A);
        int n = A.size() - 1;
        long max = 0L, min = 0L;

        for(int i = 0; i <= n; i++) {
            min = min * 2;
            min = (min + A.get(i)) % pow;
        }

        for(int i = n; i>= 0; i--) {
            max = max * 2;
            max = (max + A.get(i)) % pow;
        }

        long ans = ((max - min) + pow) % pow;

        return (int) ans;
    }
}
