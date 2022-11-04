public class Solution {
    public int solve(int A) {
        int count = 0;
        for(int i = 1; i * i <= A; i++) {
            count++;
        }

        return count;
    }
}
