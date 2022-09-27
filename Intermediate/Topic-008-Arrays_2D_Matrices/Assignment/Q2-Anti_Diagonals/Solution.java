public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> arr) {
        int n = arr.size();

        int actualRow = (2 * n) - 1;
        int actualColumn = n;

        int[][] temp = new int[actualRow][actualColumn];

        int i;
        for(i = 0; i<n; i++) {
            int row = 0;
            int column = i;

            while(column >= 0) {
                temp[i][row] = arr.get(row).get(column);
                row++;
                column--;
            }

        }





        for(int k = i; k<actualRow; k++) {
            int column = n - 1;
            int row = k - column;

            while(row < n) {
                temp[k][(n - 1) - column] = arr.get(row).get(column);
                row++;
                column--;
            }
        }







        ArrayList<ArrayList<Integer>> diagonalArr = new ArrayList<>();
        for(i=0; i<actualRow; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j = 0; j< actualColumn; j++) {
                tmp.add(temp[i][j]);
            }

            diagonalArr.add(tmp);
        }

        return diagonalArr;
    }
}
