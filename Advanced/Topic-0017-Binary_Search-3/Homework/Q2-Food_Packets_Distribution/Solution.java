public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        long sum = 0;
        int high = Integer.MAX_VALUE, low = 1;
        for(Integer num : A) {
            sum += num;
            high = Math.min(high, num);
        }
        if((long)B > sum) return 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isNumberOfPeople(A, (long)B, (long)mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low - 1;
    }

    public boolean isNumberOfPeople(ArrayList<Integer> A, long providedOffice, long people) {
        long requiredOffice = 0;
        for(int i = 0; i < A.size(); i++) {
            requiredOffice += A.get(i) / people;
        }

        if(requiredOffice >= providedOffice) return true;
        return false;
    }
}
