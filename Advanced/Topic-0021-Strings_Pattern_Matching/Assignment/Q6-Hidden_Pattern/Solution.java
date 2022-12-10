public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final String A, final String B) {
        StringBuilder str = new StringBuilder();
        str.append(B)
                .append("$")
                .append(A);
        int[] lps = new int[str.length()];
        lps[0] = 0;
        for(int i = 1; i < str.length(); i++) {
            int x = lps[i - 1];
            while(str.charAt(i) != str.charAt(x)) {
                if(x == 0) {
                    x = x - 1;
                    break;
                }
                x = lps[x - 1];
            }

            lps[i] = x + 1;
        }

        int count = 0;

        for(int i = 0; i < lps.length; i++) {
            if(B.length() == lps[i]) count++;
        }

        return count;
    }
}
