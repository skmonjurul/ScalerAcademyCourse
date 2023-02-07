public class Solution {
    public int solve(int A) {
        // return letsPartyWithRecursion(A);

        // int[] cache = new int[A + 1];
        // Arrays.fill(cache, -1);
        // return letsPartyWithRecursionWithCache(A, cache);


        // return letsPartyWithBottomUp(A);


        return letsPartyWithBottomUpWithSpaceOptimization(A);
    }

    public int letsPartyWithRecursion(int A) {
        if(A <= 1) return 1;

        return (letsPartyWithRecursion(A - 1) % 10003 + ((A - 1) * letsPartyWithRecursion(A - 2)) % 10003) % 10003;
    }

    public int letsPartyWithRecursionWithCache(int A, int[] cache) {
        if(A <= 1) return 1;

        if(cache[A] != -1) return cache[A];

        cache[A] = (letsPartyWithRecursionWithCache(A - 1, cache) % 10003 + ((A - 1) * letsPartyWithRecursionWithCache(A - 2, cache)) % 10003) % 10003;
        return cache[A];
    }

    public int letsPartyWithBottomUp(int A) {
        int[] cache = new int[A + 1];
        cache[0] = 1;
        cache[1] = 1;

        for(int people = 2; people <= A; people++) {
            cache[people] = (cache[people - 1] % 10003 + ((people - 1) * cache[people - 2]) % 10003) % 10003;
        }

        return cache[A];
    }

    public int letsPartyWithBottomUpWithSpaceOptimization(int A) {
        int x = 1;
        int y = 1;

        for(int people = 2; people <= A; people++) {
            int temp = y;
            y = (y % 10003 + ((people - 1) * x) % 10003) % 10003;
            x = temp;
        }

        return y;
    }
}
