public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();

        int[][] matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // if the element is not 0
                if(!A.get(i).get(j).equals(0)) {
                    // for the first column it is 1
                    if(j == 0) matrix[i][j] = 1;
                        // for the other column do prefixsum
                    else matrix[i][j] = 1 + matrix[i][j - 1];
                }

            }
        }




        int area = 0;
        // visit each cell, and for each cell go up and calculate the area
        // if the cell value is not 0
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // if the cell value is not zero
                if(matrix[i][j] != 0) {
                    // initially width is MAX
                    // as we go up we need to consider the minimum width
                    int w = Integer.MAX_VALUE;
                    // initially the height is 1 as we go up height will increase by 1
                    int h = 1;
                    for(int k = i; k >= 0; k--) {
                        w = Math.min(w, matrix[k][j]);
                        // calculate the max area
                        area = Math.max(area, w * h);
                        // incerase the height by 1
                        h++;
                    }
                }
            }
        }


        return area;
    }
}
