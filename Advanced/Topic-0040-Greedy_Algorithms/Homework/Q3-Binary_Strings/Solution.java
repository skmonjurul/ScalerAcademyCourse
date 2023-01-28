public class Solution {
    public int solve(String A, int B) {
        int n = A.length();
        // this array is used keep track of flip operation
        // example at any index i, we set i + B = 1, to keep track of when flip operation
        // is getting over
        int[] flipMonitor = new int[n];

        // to keep track of number of flip operations performed
        int flipCount = 0;

        // to keep track of flip operation at every step
        // xor == 1 - flip is in progress
        // xor == 0 - no flip operation in progress
        int xor = 0;

        // observations
        // At any index i, if flip is not in progress i.e xor == 0 and A[i] == 0, it means flip is required
        // Similarly we can say that at any index i, if flip is in progress i.e xor == 1 and A[i] == 1, it means flip is required
        // as flip in progress with A[i] == 1 means A[i] value is now 0, hence flip is required again

        // We can perform flips only from 0 to n - B index
        // after n- B th index there is no enough B elements to perform flip operation
        // So, after n - B th index we will only check whether all subsequent element resultant value is 1, if not then return -1
        for(int i = 0; i < n - B + 1; i++){

            xor ^= flipMonitor[i]; // reset flip after B elements, since for i we are setting flipMonitor[i + B] = 1

            if((xor == 0 && A.charAt(i) == '0') ||
                    (xor == 1 && A.charAt(i) == '1')){
                // flip is required
                flipCount++;
                xor ^= 1; // flip is now in progress
                if(i + B < n){
                    flipMonitor[i + B] = 1;
                }
            }
        }

        for(int i = n - B + 1; i < n; i++){
            xor ^= flipMonitor[i]; // if flipMonitor[i] is 1 then it will reset the xor

            if((xor ^ (A.charAt(i) - '0')) == 0){
                return -1;
            }
        }
        return flipCount;

    }
}
