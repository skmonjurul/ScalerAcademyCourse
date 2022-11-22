public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A, int B) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for(Integer num : A) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        if(B == 1) return low;
        if(B == A.size()) return high;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isMinPossible_v2(B, mid, A)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low - 1;
    }


    public boolean isMinPossible(int B, int possible, List<Integer> A) {
        int count = 0;
        boolean isFound = false;
        for(Integer num : A) {
            if(num == possible) isFound = true;
            if(num <= possible) count++;
        }

        return count <= B && isFound;
    }

    public boolean isMinPossible_v2(int B, int possible, List<Integer> A) {
        int lessCount = 0;
        for(Integer num : A) {
            if(num < possible) lessCount++;
        }

        //if B is less than lesscount + 1, then need to do mid - 1;
        if(B < lessCount + 1) return false;

        return true;
    }
}
