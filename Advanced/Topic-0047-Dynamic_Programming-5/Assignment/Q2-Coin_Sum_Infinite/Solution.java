public class Solution {
    public int coinchange2(ArrayList<Integer> A, int B) {

        // return coinchange2Recursion(A, B, 0);
        return coinchange2DP(A, B);
    }

    public int coinchange2Recursion(ArrayList<Integer> A, int B, int index) {
        if(B == 0) return 1;

        if(index == A.size()) return 0;

        int mod = 1000 * 1000 + 7;

        long total = 0;

        int skip = coinchange2Recursion(A, B, index + 1);

        total += skip;

        total %= mod;

        if(A.get(index) <= B) {
            int take = coinchange2Recursion(A, B - A.get(index), index);
            total += take;

            total %= mod;
        }

        return (int)total;
    }

    public int coinchange2DP(ArrayList<Integer> A, int B) {
        int[][] cache = new int[A.size()][B + 1];

        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return coinchange2DPHelper(A, B, 0, cache);

    }

    public int coinchange2DPHelper(ArrayList<Integer> A, int B, int index, int[][] cache) {
        if(B == 0) return 1;

        if(index == A.size()) return 0;

        if(cache[index][B] == -1) {
            int mod = 1000 * 1000 + 7;

            long total = 0;

            int skip = coinchange2DPHelper(A, B, index + 1, cache);

            total += skip;

            total %= mod;

            if(A.get(index) <= B) {
                int take = coinchange2DPHelper(A, B - A.get(index), index, cache);
                total += take;

                total %= mod;
            }

            cache[index][B] = (int)total;
        }

        return cache[index][B];
    }
}
