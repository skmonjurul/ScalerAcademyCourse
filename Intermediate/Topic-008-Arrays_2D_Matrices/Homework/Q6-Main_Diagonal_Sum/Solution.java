public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<ArrayList<Integer>> arr) {
        int row = arr.size();

        int sum = 0;
        for(int i = 0; i<row; i++) {
            sum += arr.get(i).get(i);
        }

        return sum;
    }
}
