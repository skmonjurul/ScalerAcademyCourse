public class Solution {
    public int solve(ArrayList<Integer> arr) {

        long sum = 0L;

        Set<Long> prefixSum = new HashSet<>();
        for(int i=0; i<arr.size(); i++) {
            sum += arr.get(i);
            if(sum == 0) {
                return 1;
            }

            if(prefixSum.contains(sum)) {
                return 1;
            } else {
                prefixSum.add(sum);
            }
        }

        return 0;
    }
}
