public class Solution {
    public int solve(ArrayList<Integer> A) {
        A.sort(Collections.reverseOrder());

        int sum = 0;
        for(Integer num : A) {
            sum += num;
        }

        int minCost = 0;
        for(int i = 0; i < A.size(); i++) {
            minCost += sum;
            sum -= A.get(i);
        }

        return minCost;
    }
}
