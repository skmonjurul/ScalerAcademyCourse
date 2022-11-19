public class Solution {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A.get(mid) <= B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return low > 0 && A.get(low - 1) == B ? low - 1 : low;
    }
}
