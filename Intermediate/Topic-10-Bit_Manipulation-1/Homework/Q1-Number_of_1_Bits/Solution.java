public class Solution {
    public int numSetBits(int A) {
        int x = A;
        int count = 0;
        while(x != 0) {
            if((x & 1) == 1) count++;
            x = x >> 1;
        }

        return count;
    }
}
