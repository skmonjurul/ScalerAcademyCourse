public class Solution {
    private final int EMPTY = 0;
    private final int FRESH = 1;
    private final int ROTTEN = 2;
    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<Triplet> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(A[i][j] == ROTTEN) {
                    // visited[i][j] = true;
                    queue.add(new Triplet(i, j, 0));
                }
            }
        }


        int days = 0;

        while(!queue.isEmpty()) {
            Triplet orange = queue.poll();
            int row = orange.row;
            int column = orange.column;
            days = orange.minDays;

            if(visited[row][column]) continue;

            visited[row][column] = true;

            if(row + 1 < n && A[row + 1][column] == FRESH) {
                queue.add(new Triplet(row + 1, column, days + 1));
                A[row + 1][column] = ROTTEN;
            }


            if(row - 1 >= 0 && A[row - 1][column] == FRESH) {
                queue.add(new Triplet(row - 1, column, days + 1));
                A[row - 1][column] = ROTTEN;
            }


            if(column + 1 < m && A[row][column + 1] == FRESH) {
                queue.add(new Triplet(row, column + 1, days + 1));
                A[row][column + 1] = ROTTEN;
            }


            if(column - 1 >= 0 && A[row][column - 1] == FRESH) {
                queue.add(new Triplet(row, column - 1, days + 1));
                A[row][column - 1] = ROTTEN;
            }


        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && A[i][j] != EMPTY) {
                    return -1;
                }
            }
        }

        return days;

    }
}

class Triplet {
    int row;
    int column;
    int minDays;

    public Triplet(int row, int column, int minDays) {
        this.row = row;
        this.column = column;
        this.minDays = minDays;
    }
}
