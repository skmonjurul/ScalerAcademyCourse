public class Solution {
    public int solve(String A) {
        int i = 0, j = A.length() - 1;

        int mismatchCount = 0;
        while(i <= j) {
            if(A.charAt(i) != A.charAt(j)) mismatchCount++;
            i++;
            j--;
        }

        if(mismatchCount == 0) {
            return 0;
        }


        i = 0; j = A.length() - 1;
        int temp = 0;
        while(i < j) {
            //do j-- untill j character is not eqal to i
            while(i < j && A.charAt(j) != A.charAt(i)) j--;
            // store the j pointer into any temp variable
            temp = j;

            // check from i to j, that portion of the string is prime or not
            while(i < j) {
                //if not prime then reset i = 0, and break;
                if(A.charAt(i) != A.charAt(j)) {
                    i = 0;
                    break;
                }
                i++;
                j--;
            }
            if(i >= j) break;
        }

        return A.length() - temp - 1;
    }
}
