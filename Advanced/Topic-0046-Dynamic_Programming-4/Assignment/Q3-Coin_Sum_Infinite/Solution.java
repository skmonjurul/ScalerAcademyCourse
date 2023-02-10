public class Solution {
    public int coinchange2(ArrayList<Integer> A, int B) {
        // return coinchange2Recursion(A, 0, B);
        return coinchange2DP(A, B);
    }

    public int coinchange2Recursion(ArrayList<Integer> A, int index, int B) {
        if(B == 0) return 1;
        if(index == A.size()) return 0;

        int mod = 1000 * 1000 + 7;

        long skip = coinchange2Recursion(A, index + 1, B) % mod;

        if(A.get(index) <= B) {
            long take = coinchange2Recursion(A, index, B - A.get(index)) % mod;
            skip = (skip + take) % mod;
        }

        return (int)skip;
    }

    public int coinchange2DP(ArrayList<Integer> A, int B) {
        int[][] cache = new int[A.size()][B + 1];
        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return coinchange2DPHelper(A, 0, B, cache);
    }

    public int coinchange2DPHelper(ArrayList<Integer> A, int index, int B, int[][] cache) {
        if(B == 0) return 1;
        if(index == A.size()) return 0;

        int mod = 1000 * 1000 + 7;

        if(cache[index][B] == -1) {
            int skip = coinchange2DPHelper(A, index + 1, B, cache);

            if(A.get(index) <= B) {
                int take = coinchange2DPHelper(A, index, B - A.get(index), cache);
                skip = (int) ((skip + (long)take) % mod);
            }

            cache[index][B] = skip;
        }

        return cache[index][B];
    }
}
