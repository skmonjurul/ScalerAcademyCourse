public class Solution {

    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][] blocks;

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        int n = a.size();

        rows = new boolean[n][10];
        cols = new boolean[n][10];
        blocks = new boolean[n][10];


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a.get(i).get(j) != '.') {
                    char ch = a.get(i).get(j);
                    int number = Integer.parseInt(String.valueOf(ch));
                    rows[i][number] = true;
                    cols[j][number] = true;
                    int block = ((i / 3) * 3) + (j / 3);
                    blocks[block][number] = true;
                }
            }
        }


        sudoku(0, n, a);


    }


    public boolean sudoku(int cell, int n, ArrayList<ArrayList<Character>> a) {
        if(cell == n * n) {
            return true;
        }

        int r = cell / n;
        int c = cell % n;

        int block = ((r / 3) * 3) + (c / 3);

        if(a.get(r).get(c) == '.') {
            for(char ch = '1'; ch <= '9'; ch++) {
                int number = Integer.parseInt(String.valueOf(ch));

                if(rows[r][number]) continue;

                if(cols[c][number]) continue;

                if(blocks[block][number]) continue;


                rows[r][number] = true;
                cols[c][number] = true;
                blocks[block][number] = true;
                a.get(r).set(c, ch);

                if(sudoku(cell + 1, n, a)) return true;
                else {
                    rows[r][number] = false;
                    cols[c][number] = false;
                    blocks[block][number] = false;
                    a.get(r).set(c, '.');
                }
            }
        }

        else {
            if(sudoku(cell + 1, n, a)) return true;
        }

        return false;


    }
}
