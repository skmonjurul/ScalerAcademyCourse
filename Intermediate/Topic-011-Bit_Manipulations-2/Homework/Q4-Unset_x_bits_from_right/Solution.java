public class Solution {
    public Long solve(Long A, int B) {
        long max = Long.MAX_VALUE;
        long num = max ^ (max >> (63 - B));
        return A & num;
    }
}
