public class Solution {
    public int solve(int A) {
        int n = A;
        boolean firstUnsetBit = false;
        int i = 0, maxSmall = 0;
        while(n != 0) {
            if((n & 1) == 0) {
                maxSmall += 1 << i;
            }
            i++;
            n = n >> 1;
        }

        return (1 << i) ^ maxSmall;
    }
}
