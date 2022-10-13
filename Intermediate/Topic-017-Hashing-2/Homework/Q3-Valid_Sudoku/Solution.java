public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isValidSudoku(final List<String> arr) {

        int n = arr.size();
        Map<Integer, Boolean> rowValid = new HashMap<>();
        Map<Integer, Boolean> columnValid = new HashMap<>();

        char[][] sudokuBoard = new char[n][n];

        for(int i = 0; i<arr.size(); i++) {
            sudokuBoard[i] = arr.get(i).toCharArray();
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!isValid(sudokuBoard, i, j, rowValid, columnValid)) return 0;
            }
        }

        return 1;
    }



    public boolean isValid(final char[][] sudokuBoard, int row, int column,
                           Map<Integer, Boolean> rowValid,
                           Map<Integer, Boolean> columnValid) {

        boolean isRowValid;
        boolean isColumnValid;


        if(rowValid.containsKey(row)) {
            isRowValid = rowValid.get(row);
        } else {
            isRowValid = isRowValid(sudokuBoard, row);
            rowValid.put(row, isRowValid);
        }

        if(columnValid.containsKey(column)) {
            isColumnValid = columnValid.get(column);
        } else {
            isColumnValid = isColumnValid(sudokuBoard, column);
            columnValid.put(column, isColumnValid);
        }


        boolean isBoxValid = isBoxValid(sudokuBoard, row - row % 3, column - column % 3);

        return isRowValid && isColumnValid && isBoxValid;
    }

    public boolean isRowValid(final char[][] sudokuBoard, int row) {
        Set<Character> fullRow = new HashSet<>();
        for(int i = 0; i < sudokuBoard.length; i++) {
            if(fullRow.contains(sudokuBoard[row][i])) {
                return false;
            }
            if(sudokuBoard[row][i] != '.') {
                fullRow.add(sudokuBoard[row][i]);
            }
        }

        return true;
    }

    public boolean isColumnValid(final char[][] sudokuBoard, int column) {
        Set<Character> fullColumn = new HashSet<>();
        for(int i = 0; i < sudokuBoard.length; i++) {
            if(fullColumn.contains(sudokuBoard[i][column])) {
                return false;
            }
            if(sudokuBoard[i][column] != '.') {
                fullColumn.add(sudokuBoard[i][column]);
            }
        }

        return true;
    }

    public boolean isBoxValid(final char[][] sudokuBoard, int row, int column) {
        Set<Character> wholeBox = new HashSet<>();
        for(int i = 0; i<3; i++) {
            for(int j = 0; j < 3; j++) {
                if(wholeBox.contains(sudokuBoard[i + row][j + column])) return false;
                if(sudokuBoard[i + row][j + column] != '.') {
                    wholeBox.add(sudokuBoard[i + row][j + column]);
                }
            }
        }

        return true;
    }

}
