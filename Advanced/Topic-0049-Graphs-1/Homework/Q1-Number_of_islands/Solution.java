public class Solution {
    private final int LAND = 1;
    private final int WATER = 0;

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int column = A.get(0).size();

        boolean[][] visited = new boolean[row][column];

        int numberOfland = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(visited[i][j] || A.get(i).get(j) == WATER) continue;
                numberOfland++;
                dfs(A, i, j, visited);
            }
        }

        return numberOfland;
    }


    public void dfs(ArrayList<ArrayList<Integer>> A, int row, int column, boolean[][] visited) {
        // if row and column outside the matrix
        if(row < 0 || row >= A.size() || column < 0 || column >= A.get(0).size()) return;

        // if already visited
        if(visited[row][column]) return;

        // if water
        if(A.get(row).get(column) == WATER) return;

        visited[row][column] = true;

        dfs(A, row - 1, column, visited);
        dfs(A, row, column - 1, visited);
        dfs(A, row + 1, column, visited);
        dfs(A, row, column + 1, visited);
        dfs(A, row - 1, column - 1, visited);
        dfs(A, row - 1, column + 1, visited);
        dfs(A, row + 1, column + 1, visited);
        dfs(A, row + 1, column - 1, visited);
    }
}
