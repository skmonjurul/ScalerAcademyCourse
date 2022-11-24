public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(B > A.size()) return -1;

        long low = 0, min = Integer.MAX_VALUE;
        long high = 0;
        for(Integer pageNo : A) {
            high += pageNo;
            min = Math.min(min, pageNo);
        }

        low = min;


        if(B == 1) return (int)high;



        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(!isPageNoPossible(A, B, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return (int)low;
    }

    public boolean isPageNoPossible(ArrayList<Integer> A, int B, long expectedPageNumber) {
        int i = 0;
        while(B > 0) {
            long prevPageNo = 0;
            while(i < A.size() && prevPageNo + A.get(i) <= expectedPageNumber){
                prevPageNo += A.get(i);
                i++;
            }

            // if(i == A.size() && B == 1) return true;
            if(i == A.size()) return true;
            B--;
        }

        return false;
    }
}
