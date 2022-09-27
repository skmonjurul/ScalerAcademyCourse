public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<ArrayList<Integer>> arr) {
        int n = arr.size();

        int sum = 0;
        for(int i = 0; i<n; i++) {
            int column = (n - 1) - i;
            sum += arr.get(i).get(column);
        }

        return sum;
    }
}
