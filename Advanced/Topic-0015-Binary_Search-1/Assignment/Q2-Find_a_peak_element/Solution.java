public class Solution {
    public int solve(ArrayList<Integer> A) {
        int low = 0, high = A.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(mid + 1 < A.size() && A.get(mid) <= A.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return A.get(low);
    }
}
