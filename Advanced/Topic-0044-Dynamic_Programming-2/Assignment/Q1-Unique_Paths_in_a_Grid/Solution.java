public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        return uniquePathsWithObstacles(A, 0, 0, n, m);
    }

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A, int startRow, int startColumn, int n, int m) {
        if(A.get(startRow).get(startColumn) == 1) return 0;
        if(startRow == n - 1 && startColumn == m - 1) return 1;

        int totalPaths = 0;

        if(startColumn < m - 1 && A.get(startRow).get(startColumn + 1) != 1)
            totalPaths += uniquePathsWithObstacles(A, startRow, startColumn + 1, n, m);
        if(startRow < n - 1 && A.get(startRow + 1).get(startColumn) != 1)
            totalPaths += uniquePathsWithObstacles(A, startRow + 1, startColumn, n, m);

        return totalPaths;

    }
}
