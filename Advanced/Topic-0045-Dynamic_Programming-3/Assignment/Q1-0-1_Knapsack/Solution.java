public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        // return knapsackRecursive(A, B, C, 0);
        // return knapsackDP(A, B, C);
        return knapsackBottomUp(A, B, C);
    }

    public int knapsackRecursive(ArrayList<Integer> A, ArrayList<Integer> B, int C, int index) {
        if(index == A.size() && C >= 0) return 0;
        if(C < 0) return Integer.MIN_VALUE;

        int take = A.get(index) + knapsackRecursive(A, B, C - B.get(index), index + 1);

        int skip = knapsackRecursive(A, B, C, index + 1);

        return Math.max(take, skip);
    }

    public int knapsackDP(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int[][] cache = new int[A.size()][C + 1];
        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return knapsackDPHelper(A, B, C, 0, cache);
    }

    public int knapsackDPHelper(ArrayList<Integer> A, ArrayList<Integer> B, int C, int index, int[][] cache) {
        if(index == A.size() && C >= 0) return 0;
        if(C < 0) return Integer.MIN_VALUE;

        if(cache[index][C] != -1) return cache[index][C];

        int take = A.get(index) + knapsackDPHelper(A, B, C - B.get(index), index + 1, cache);

        int skip = knapsackDPHelper(A, B, C, index + 1, cache);

        cache[index][C] = Math.max(take, skip);

        return cache[index][C];
    }

    public int knapsackBottomUp(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int[][] maxValue = new int[A.size() + 1][C + 1];

        for(int index = A.size() - 1; index >= 0; index--) {
            int weight = B.get(index);
            int value = A.get(index);
            for(int c = 0; c <= C; c++) {
                int skip = maxValue[index + 1][c];
                maxValue[index][c] = skip;
                if(weight <= c) {
                    int take = value + maxValue[index + 1][c - weight];
                    maxValue[index][c] = Math.max(take, skip);
                }
            }

        }

        return maxValue[0][C];
    }
}
