public class Solution {
    public String solve(String A) {
        int i = 0, j = A.length() - 1;

        int mismatchCount = 0;
        while(i <= j) {
            if(A.charAt(i) != A.charAt(j)) mismatchCount++;
            i++;
            j--;
        }

        if(mismatchCount == 0) {
            return A.length() % 2 == 0 ? "NO" : "YES";
        }

        return mismatchCount > 1 ? "NO" : "YES";
    }
}
