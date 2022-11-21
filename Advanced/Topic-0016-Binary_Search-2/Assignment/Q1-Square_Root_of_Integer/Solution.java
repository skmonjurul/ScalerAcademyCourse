public class Solution {
    public int sqrt(int A) {
        long low = 0, high = A;

        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(mid * mid <= (long)A) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int)(low - 1);
    }
}
