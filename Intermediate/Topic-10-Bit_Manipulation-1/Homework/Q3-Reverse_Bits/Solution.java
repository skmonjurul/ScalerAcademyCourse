public class Solution {
    public long reverse(long a) {
        long num = 0;
        for(int i = 31; i >= 0; i--) {
            if((a & 1) == 1) {
                num += 1L << i;
            }
            a = a >> 1;
        }

        return num;
    }
}
