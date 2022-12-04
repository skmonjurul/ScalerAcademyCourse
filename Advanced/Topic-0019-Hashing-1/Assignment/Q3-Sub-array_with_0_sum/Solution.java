public class Solution {
    public int solve(ArrayList<Integer> A) {
        Set<Long> sumSeen = new HashSet<>();
        sumSeen.add(0L);

        long sum = 0;
        for(Integer num : A) {
            sum += num;
            if(sumSeen.contains(sum)) return 1;
            sumSeen.add(sum);
        }

        return 0;
    }
}
