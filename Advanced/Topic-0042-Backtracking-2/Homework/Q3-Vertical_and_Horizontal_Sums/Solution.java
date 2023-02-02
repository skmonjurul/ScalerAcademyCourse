public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        int n = B.size();
        int m = B.get(0).size();


        int[][] matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = B.get(i).get(j);
            }
        }


        return isPossible(matrix, A, C, n, m) ? 1 : 0;

    }

    public boolean isPossible(int[][] matrix, int A, int C, int n, int m) {
        if(A == -1) return false;

        boolean result = true;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sum = 0;
                for(int k = j; k < m; k++) {
                    sum += matrix[i][k];
                    if(sum > C) {
                        result = false;
                        for(int l = j; l <= k; l++) {
                            matrix[i][l] = -matrix[i][l];
                            result |= isPossible(matrix, A - 1, C, n, m);
                            if(result) return result;
                            matrix[i][l] = -matrix[i][l];
                        }

                        return result;
                    }
                }
            }
        }



        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                int sum = 0;
                for(int k = i; k < n; k++) {
                    sum += matrix[k][j];
                    if(sum > C) {
                        result = false;
                        for(int l = i; l <= k; l++) {
                            matrix[l][j] = -matrix[l][j];
                            result |= isPossible(matrix, A - 1, C, n, m);
                            if(result) return result;
                            matrix[l][j] = -matrix[l][j];
                        }

                        return result;
                    }
                }
            }
        }


        return result;
    }
}
