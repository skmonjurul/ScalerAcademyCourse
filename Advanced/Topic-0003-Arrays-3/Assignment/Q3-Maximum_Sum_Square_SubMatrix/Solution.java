public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();

        int[][] prefixSum = new int[n][n];

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += A.get(i).get(j);
                prefixSum[i][j] = sum;
            }
        }

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += prefixSum[j][i];
                prefixSum[j][i] = sum;
            }
        }

        int max = Integer.MIN_VALUE;

        for(int row1 = 0; row1 <= (n - B); row1++) {
            for(int column1 = 0; column1 <= (n - B); column1++) {
                int x1 = row1;
                int y1 = column1;

                int x2 = row1 + (B - 1);
                int y2 = column1 + (B - 1);

                int sum = 0;

                if(x1 == 0 && y1 == 0) {
                    sum = prefixSum[x2][y2];
                } else if(x1 == 0) {
                    sum = (prefixSum[x2][y2] - prefixSum[x2][y1 - 1]);
                } else if(y1 == 0) {
                    sum = (prefixSum[x2][y2] - prefixSum[x1 - 1][y2]);
                } else {
                    sum = (prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1]) + prefixSum[x1 - 1][y1 - 1];
                }

                max = Math.max(max, sum);

            }
        }

        return max;
    }
}
