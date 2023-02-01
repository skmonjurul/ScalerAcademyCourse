public class Solution {

    private ArrayList<ArrayList<String>> solution;
    private boolean[][] board;
    private boolean[] column;
    private boolean[] diagonal;
    private boolean[] antiDiagonal;

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        solution = new ArrayList<>();

        board = new boolean[A][A];
        column = new boolean[A];
        diagonal = new boolean[2 * A - 1];
        antiDiagonal = new boolean[2 * A - 1];

        nQueen(0, A);

        return solution;

    }

    public void nQueen(int row, int A) {
        if(row == A) {
            ArrayList<String> result = new ArrayList<>();
            for(int i = 0; i < A; i++) {
                StringBuilder r = new StringBuilder();
                for(int j = 0; j < A; j++) {
                    if(board[i][j]) {
                        r.append("Q");
                    }

                    else {
                        r.append(".");
                    }
                }

                result.add(r.toString());
            }

            solution.add(result);
        }

        for(int col = 0; col < A; col++) {
            if(column[col]) continue;

            if(diagonal[row + col]) continue;

            if(antiDiagonal[row - col + A - 1]) continue;

            board[row][col] = true;
            column[col] = true;
            diagonal[row + col] = true;
            antiDiagonal[row - col + A - 1] = true;

            nQueen(row + 1, A);

            board[row][col] = false;
            column[col] = false;
            diagonal[row + col] = false;
            antiDiagonal[row - col + A - 1] = false;
        }


    }
}
