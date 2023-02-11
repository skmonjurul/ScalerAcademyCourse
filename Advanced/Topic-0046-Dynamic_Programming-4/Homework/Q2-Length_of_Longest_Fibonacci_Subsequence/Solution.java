public class Solution {
    public int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> index = new HashMap<>();

        for(int i = 0; i < A.size(); i++) {
            index.put(A.get(i), i);
        }

        int n = A.size();
        int[][] longest = new int[n][n];

        int maxLength = 0;

        for(int k = 0; k < n; k++) {
            for(int j = 0; j < n; j++) {
                if(A.get(k) - A.get(j) < A.get(j) && index.containsKey(A.get(k) - A.get(j))) {
                    int i = index.get(A.get(k) - A.get(j));
                    longest[j][k] = 1 + longest[i][j];
                    maxLength = Math.max(maxLength, longest[j][k] + 2);
                }
            }
        }


        return maxLength >= 3 ? maxLength : 0;
    }
}
