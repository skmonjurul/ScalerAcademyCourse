public class Solution {
    public int solve(int A) {
        return waysToSendSignalDP(A);
    }

    public int waysToSendSignalRecursion(int A) {
        if(A == 0) return 1;
        if(A == 1) return 2;


        int mod = 1000 * 1000 * 1000 + 7;
        return (solve(A - 2) % mod + solve(A - 1) % mod) % mod;
    }

    public int waysToSendSignalDP(int A) {
        int[] cache = new int[A + 1];
        Arrays.fill(cache, -1);

        return waysToSendSignalDPHelper(A, cache, 1000 * 1000 * 1000 + 7);
    }

    public int waysToSendSignalDPHelper(int A, int[] cache, int mod) {
        if(A == 0) return 1;
        if(A == 1) return 2;

        if(cache[A] != -1) return cache[A];

        cache[A] = (waysToSendSignalDPHelper(A - 1, cache, mod) % mod + waysToSendSignalDPHelper(A - 2, cache, mod) % mod) % mod;

        return cache[A];
    }
}
