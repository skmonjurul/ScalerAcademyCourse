public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final String A, final String B) {

        int j = 0;
        for(int i = 0; i < A.length(); i++) {
            if(j == B.length() || A.charAt(i) != B.charAt(j)) return 0;
            while(j < B.length() && B.charAt(j) == A.charAt(i)) {
                j++;
            }
        }

        if(j < B.length()) return 0;

        return 1;

    }
}
