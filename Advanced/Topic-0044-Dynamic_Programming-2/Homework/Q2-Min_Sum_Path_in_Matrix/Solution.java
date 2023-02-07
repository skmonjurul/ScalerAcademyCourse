public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        // normal recursion with Accumulating the sum

        // return minPathSumWithRecursion_v1(A, A.size(), A.get(0).size(), 0, 0, 0);

        //*******************************************************************

        // normal recursion without Accumulating the sum, getting the output and then doing the sum with current element

        // return minPathSumWithRecursion_v2(A, A.size(), A.get(0).size(), 0, 0);

        //*******************************************************************

        // recursion with cache

        // int[][] cache = new int[A.size()][A.get(0).size()];
        // // fill the cache with sentinel value
        // for(int i = 0; i < cache.length; i++) {
        //     Arrays.fill(cache[i], -1200);
        // }

        // return minPathSumRecursionWithCache(A, A.size(), A.get(0).size(), 0, 0, cache);

        //*******************************************************************

        // bottom up

        // return minPathSumWithBottomUp(A, A.size(), A.get(0).size());

        //*******************************************************************

        // bottom up with optimization

        return minPathSumWithBottomUpOptimization(A, A.size(), A.get(0).size());
    }



    /**
     M is total number of row
     N is the total number of column
     */
    public int minPathSumWithBottomUpOptimization(ArrayList<ArrayList<Integer>> A, int M, int N) {
        int[] prev = new int[N];
        int[] current;

        // get the bottom right cell value
        prev[N - 1] = A.get(M - 1).get(N - 1);

        // build the last row
        for(int column = N - 2; column >= 0; column--) {
            prev[column] = prev[column + 1] + A.get(M - 1).get(column);
        }

        for(int row = M - 2; row >= 0; row--) {
            current = new int[N];
            for(int column = N - 1; column >= 0; column--) {
                // now for each cell, I want the right value and down value
                int cellValue = A.get(row).get(column);
                // for the last column, there is no right value
                if(column == N - 1)
                    current[column] = cellValue + prev[column];
                else
                    current[column] = Math.min(cellValue + current[column + 1], cellValue + prev[column]);
            }
            prev = current;
        }

        return prev[0];
    }



    /**
     M is total number of row
     N is the total number of column
     */
    public int minPathSumWithBottomUp(ArrayList<ArrayList<Integer>> A, int M, int N) {
        int[][] cache = new int[M][N];

        // last bottom right cell
        cache[M - 1][N - 1] = A.get(M - 1).get(N - 1);

        // build the last row
        for(int column = N - 2; column >= 0; column--) {
            cache[M - 1][column] = cache[M - 1][column + 1] + A.get(M - 1).get(column);
        }

        // build th last column
        for(int row = M - 2; row >= 0; row--) {
            cache[row][N - 1] = cache[row + 1][N - 1] + A.get(row).get(N - 1);
        }

        // build the whole cache
        for(int row = M - 2; row >= 0; row--) {
            for(int column = N - 2; column >= 0; column--) {
                // get the current cell value
                int cellValue = A.get(row).get(column);
                cache[row][column] = Math.min(cellValue + cache[row][column + 1], cellValue + cache[row + 1][column]);
            }
        }

        return cache[0][0];
    }

    /**
     M is total number of row
     N is the total number of column
     */
    public int minPathSumRecursionWithCache(ArrayList<ArrayList<Integer>> A, int M, int N, int row, int column, int[][] cache) {
        if(row == M - 1 && column == N - 1) {
            cache[row][column] = A.get(row).get(column);
            return A.get(row).get(column);
        }

        if(cache[row][column] != -1200) return cache[row][column];

        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;

        if(column + 1 < N)
            right = A.get(row).get(column) + minPathSumRecursionWithCache(A, M, N, row, column + 1, cache);

        if(row + 1 < M)
            down = A.get(row).get(column) + minPathSumRecursionWithCache(A, M, N, row + 1, column, cache);

        cache[row][column] = Math.min(right, down);
        return cache[row][column];
    }


    /**
     M is total number of row
     N is the total number of column
     */
    public int minPathSumWithRecursion_v1(ArrayList<ArrayList<Integer>> A, int M, int N, int row, int column, int sum) {

        // int sum = A.get(row).get(column);

        if(row == M - 1 && column == N - 1) return sum + A.get(row).get(column);

        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;

        if(column + 1 < N)
            right = minPathSumWithRecursion_v1(A, M, N, row, column + 1, sum + A.get(row).get(column));

        if(row + 1 < M)
            down = minPathSumWithRecursion_v1(A, M, N, row + 1, column, sum + A.get(row).get(column));

        return Math.min(right, down);
    }



    /**
     M is total number of row
     N is the total number of column
     */
    public int minPathSumWithRecursion_v2(ArrayList<ArrayList<Integer>> A, int M, int N, int row, int column) {

        if(row == M - 1 && column == N - 1) return A.get(row).get(column);

        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;

        if(column + 1 < N)
            right = A.get(row).get(column) + minPathSumWithRecursion_v2(A, M, N, row, column + 1);

        if(row + 1 < M)
            down = A.get(row).get(column) + minPathSumWithRecursion_v2(A, M, N, row + 1, column);

        return Math.min(right, down);
    }
}
