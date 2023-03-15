public class Solution {
    public Long subarraySum(ArrayList<Integer> arr) {
        Long n = (long) arr.size();
        Long sum = 0L;
        for(int i = 0; i< n; i++) {
            sum += arr.get(i) * (n - i) * (i + 1);
        }
        return sum;
    }
}
