public class Solution {
    public int climbStairs(int A) {
        // long[] cache = new long[A + 1];
        // Arrays.fill(cache, -1);
        // return climbStairsWithRecursion(A, cache);

        return climbStairsWithBottomUp(A);
    }

    public int climbStairsWithRecursion(int A, long[] cache) {
        if(A <= 1) {
            cache[A] = 1;
            return (int)cache[A];
        }

        int mod = 1000 * 1000 * 1000 + 7;

        if(cache[A] == -1) {
            cache[A] = (climbStairsWithRecursion(A - 1, cache) % mod  + climbStairsWithRecursion(A - 2, cache) % mod) % mod;
        }

        return (int) cache[A];
    }

    public int climbStairsWithBottomUp(int A) {
        long[] cache = new long[A + 1];
        cache[0] = 1;
        cache[1] = 1;

        int mod = 1000 * 1000 * 1000 + 7;

        // for(int i = A - 2; i >= 0; i--) {
        //     cache[i] = (cache[i + 1] % mod + cache[i + 2] % mod) % mod;
        // }

        for(int i = 2; i < cache.length; i++) {
            cache[i] = (cache[i - 1] % mod + cache[i - 2] % mod) % mod;
        }

        return (int)cache[cache.length - 1];
    }
}
