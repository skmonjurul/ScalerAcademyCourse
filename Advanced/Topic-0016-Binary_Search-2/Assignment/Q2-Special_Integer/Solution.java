public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int low = 1, high = A.size();

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(A, (long)B, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low - 1;

    }

    public boolean isPossible(ArrayList<Integer> A, long B, int k) {
        long sum = 0;
        for(int i = 0; i < k; i++) {
            sum += A.get(i);
        }

        if(sum > B) return false;

        for(int i = 1; i <= A.size() - k; i++) {
            sum -= A.get(i - 1);
            sum += A.get(i + k - 1);
            if(sum > B) return false;
        }

        return true;
    }
}
