public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int row = A.size();
        int column = A.get(0).size();
        long[][] prefixSum = new long[row][column];

        for(int i = 0; i < row; i++) {
            long sum = 0;
            for(int j = 0; j < column; j++) {
                sum += A.get(i).get(j);
                prefixSum[i][j] = sum;
            }
        }

        for(int i = 0; i < column; i++) {
            long sum = 0;
            for(int j = 0; j < row; j++) {
                sum += prefixSum[j][i];
                prefixSum[j][i] = sum;
            }
        }

        int querySize = B.size();
        ArrayList<Integer> result = new ArrayList<>();
        double modValue = Math.pow(10, 9) + 7;
        for(int i = 0; i < querySize; i++) {
            int x1 = B.get(i) - 1;
            int y1 = C.get(i) - 1;

            int x2 = D.get(i) - 1;
            int y2 = E.get(i) - 1;
            long sum = 0;
            if(x1 == 0 && y1 == 0) {
                sum = prefixSum[x2][y2];
            } else if(x1 == 0) {
                sum = (prefixSum[x2][y2] - prefixSum[x2][y1 - 1]);
            } else if(y1 == 0) {
                sum = (prefixSum[x2][y2] - prefixSum[x1 - 1][y2]);
            } else {
                sum = (prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1]) + prefixSum[x1 - 1][y1 - 1];
            }

            result.add(
                    (int) (((sum % modValue) + modValue) % modValue)
            );
        }

        return result;
    }
}
