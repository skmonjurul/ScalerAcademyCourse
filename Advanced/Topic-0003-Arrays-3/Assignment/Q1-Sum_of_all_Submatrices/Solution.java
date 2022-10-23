public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> arr) {
        int n = arr.size();
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int noOfSubMatrix = (i + 1) * (j + 1) * (n - i) * (n - j);
                sum += noOfSubMatrix * arr.get(i).get(j);
            }
        }

        return sum;
    }
}
