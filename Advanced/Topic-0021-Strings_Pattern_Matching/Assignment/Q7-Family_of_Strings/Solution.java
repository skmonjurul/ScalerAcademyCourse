public class Solution {
    public int solve(int A, int B) {
        if(B == 0) return 0;
        long low = 0;

        int ans = 0;
        long high = 2;

        for(int i = 0; i <= A; i++) {
            high *= 2;
        }

        high--;

        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(B == mid) break;
            if(B < mid) high = mid - 1;
            else {
                low = mid + 1;
                ans ^= 1;
            }
        }

        return ans;


    }
}
