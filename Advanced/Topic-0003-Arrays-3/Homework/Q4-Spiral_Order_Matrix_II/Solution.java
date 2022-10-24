public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[][] matrix = new int[A][A];

        for(int i = 0; i < A; i++) {
            for(int j = 0; j < A; j++) {
                matrix[i][j] = 0;
            }
        }

        int i = 0, j = 0, k = 1, dir = 0;

        while(k <= A * A) {
            matrix[i][j] = k;
            k++;
            if(dir == 0) {
                j++;
                if(j == A || matrix[i][j] != 0) {
                    dir = 1;
                    j--;
                    i++;
                }
            }

            else if(dir == 1) {
                i++;
                if(i == A || matrix[i][j] != 0) {
                    dir = 2;
                    i--;
                    j--;
                }
            }

            else if(dir == 2) {
                j--;
                if(j < 0 || matrix[i][j] != 0) {
                    dir = 3;
                    j++;
                    i--;
                }
            }

            else {
                i--;
                if(i < 0 || matrix[i][j] != 0) {
                    dir = 0;
                    i++;
                    j++;
                }
            }
        }

        for(i = 0; i<A; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(j = 0; j < A; j++) {
                temp.add(matrix[i][j]);
            }
            arr.add(temp);
        }

        return arr;


    }
}
