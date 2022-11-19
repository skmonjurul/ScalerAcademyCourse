public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        if(A.size() == 1) {
            if(A.get(0) == B) return 0;
            else return -1;
        }

        int pivot = findPivot(A);

        int low = 0, high = A.size() - 1, n = A.size();

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int rotatedMid = (mid + pivot) % n;

            if(A.get(rotatedMid) <= B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low--;
        int index = (low + pivot) % n;

        return A.get(index) == B ? index : -1;
    }

    public int findPivot(List<Integer> A) {
        int low = 0, high = A.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A.get(A.size() - 1) < A.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
