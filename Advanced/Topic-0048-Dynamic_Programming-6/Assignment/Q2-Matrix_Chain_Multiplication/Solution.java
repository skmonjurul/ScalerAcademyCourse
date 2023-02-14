public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size() - 1;
        // return matrixMultiplication(A, 0, n - 1);

        return matrixMultiplicationDP(A, n);
    }

    public int matrixMultiplication(ArrayList<Integer> A, int start, int end) {
        if(start == end) return 0;

        int min = Integer.MAX_VALUE;

        for(int mid = start; mid < end; mid++) {
            int value = matrixMultiplication(A, start, mid) + matrixMultiplication(A, mid + 1, end) +
                    A.get(start) * A.get(mid + 1) * A.get(end + 1);

            min = Math.min(min, value);
        }

        return min;
    }

    public int matrixMultiplicationDP(ArrayList<Integer> A, int n) {
        int[][] cache = new int[n][n];

        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return matrixMultiplicationDPHelper(A, 0, n - 1, cache);
    }

    public int matrixMultiplicationDPHelper(ArrayList<Integer> A, int start, int end, int[][] cache) {
        if(start == end) return 0;

        if(cache[start][end] == -1) {
            int min = Integer.MAX_VALUE;

            for(int mid = start; mid < end; mid++) {
                int value = matrixMultiplicationDPHelper(A, start, mid, cache) + matrixMultiplicationDPHelper(A, mid + 1, end, cache) +
                        A.get(start) * A.get(mid + 1) * A.get(end + 1);

                min = Math.min(min, value);
            }

            cache[start][end] = min;

        }

        return cache[start][end];
    }
}
