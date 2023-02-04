public class Solution {
    public int countMinSquares(int A) {
        int[] cache = new int[A + 1];
        Arrays.fill(cache, -1);
        return countMinSquaresRecursionWithCache(A, cache);
    }

    public int countMinSquaresRecursion(int A, int distinct) {

        if(A <= 3) return A;

        int min = Integer.MAX_VALUE;

        for(int i = 1; i * i <= A; i++) {
            int tempMin = countMinSquares(A - (i * i));
            min = Math.min(min, tempMin + 1);
        }

        return min;
    }

    public int countMinSquaresRecursionWithCache(int A, int[] cache) {

        if(A <= 3) {
            cache[A] = A;
            return cache[A];
        }

        int min = Integer.MAX_VALUE;

        for(int i = 1; i * i <= A; i++) {
            if(cache[A - (i * i)] == -1) {
                int tempMin = countMinSquaresRecursionWithCache(A - (i * i), cache);
                cache[A - (i * i)] = tempMin;
                min = Math.min(min, tempMin + 1);
            }
            else {
                min = Math.min(min, cache[A - (i * i)] + 1);
            }

        }

        cache[A] = min;
        return cache[A];
    }

    public int countMinSquaresWithBottomUp(int A) {
        int[] cache = new int[A + 1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 3;

        if(A <= 3) return cache[A];

        int min = Integer.MAX_VALUE;

        for(int i = 1; i * i <= A; i++) {
            int callNum = A - (i * i);
            min = Math.min(min, cache[callNum] + 1);
        }

        return cache[A];

    }
}
