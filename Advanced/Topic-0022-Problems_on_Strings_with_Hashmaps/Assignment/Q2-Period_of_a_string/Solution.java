public class Solution {
    public int solve(String A) {

        int[] lps = new int[A.length()];
        lps[0] = 0;
        for(int i = 1; i < A.length(); i++) {
            int x = lps[i - 1];
            while(A.charAt(i) != A.charAt(x)) {
                if(x == 0) {
                    x = x - 1;
                    break;
                }
                x = lps[x - 1];
            }

            lps[i] = x + 1;
        }

        int period = -1;
        boolean isPeriod = false;
        for(int i = 1; i < lps.length; i++) {
            if(lps[i] == 1) {
                period = i;
                while(i < lps.length - 1 && lps[i + 1] == lps[i] + 1) {
                    isPeriod = true;
                    i++;
                }

                if(i < lps.length - 1) isPeriod = false;
            }
        }

        if(period == -1 || !isPeriod) return A.length();

        return period;
    }
}
