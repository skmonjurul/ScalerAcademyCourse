public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size() - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A.get(mid) < A.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(A.get(low) == B) return low;
        int peak = low;
        low = 0; high = peak - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A.get(mid) <= B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(low > 0 && A.get(low - 1) == B) return low - 1;
        low = peak + 1; high = A.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A.get(mid) >= B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low > 0 && A.get(low - 1) == B ? low - 1 : -1;
    }
}
