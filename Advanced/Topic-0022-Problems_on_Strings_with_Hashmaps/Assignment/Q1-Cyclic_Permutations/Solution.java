public class Solution {
    public int solve(String A, String B) {
        StringBuilder str = new StringBuilder();
        str.append(A)
                .append("$")
                .append(B)
                .append(B);
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
        for(int i = 0; i < lps.length - 1; i++){
            if(lps[i] == A.length()) count++;
        }

        return count;
    }
}
