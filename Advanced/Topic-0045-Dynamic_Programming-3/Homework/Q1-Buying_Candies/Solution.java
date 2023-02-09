public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D) {
        // return buyingCandiesRecursion(A, B, C, D, 0);
        // return buyingCandiesWithDP(A, B, C, D);
        return buyingCandiesBottomUp(A, B, C, D);
    }

    public int buyingCandiesRecursion(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D, int index) {
        if(index == A.size()) return 0;

        int skip = buyingCandiesRecursion(A, B, C, D, index + 1);

        int take = 0;

        if(C.get(index) <= D)
            take = A.get(index) * B.get(index) + buyingCandiesRecursion(A, B, C, D - C.get(index), index);

        return Math.max(skip, take);

    }

    public int buyingCandiesWithDP(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D) {
        int[][] cache = new int[A.size() + 1][D + 1];

        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return buyingCandiesWithDPHelper(A, B, C, D, 0, cache);
    }

    public int buyingCandiesWithDPHelper(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D, int index, int[][] cache) {
        if(index == A.size()) return 0;

        if(cache[index][D] != -1) return cache[index][D];

        int skip = buyingCandiesWithDPHelper(A, B, C, D, index + 1, cache);

        int take = 0;

        if(C.get(index) <= D)
            take = A.get(index) * B.get(index) + buyingCandiesWithDPHelper(A, B, C, D - C.get(index), index, cache);

        cache[index][D] = Math.max(skip, take);

        return cache[index][D];
    }

    public int buyingCandiesBottomUp(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D) {
        int[][] maxSweet = new int[A.size() + 1][D + 1];

        for(int index = A.size() - 1; index >= 0; index--) {
            for(int d = 0; d <= D; d++) {
                // skip operation
                maxSweet[index][d] = maxSweet[index + 1][d];

                // take operation
                if(C.get(index) <= d) {
                    int take = A.get(index) * B.get(index) + maxSweet[index][d - C.get(index)];
                    maxSweet[index][d] = Math.max(maxSweet[index][d], take);
                }
            }
        }

        return maxSweet[0][D];
    }
}
