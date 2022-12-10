public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        String str = A.trim();
        // System.out.println(Integer.MIN_VALUE);
        // System.out.println(Integer.MAX_VALUE);
        if(!(str.charAt(0) - '0' >= 0 && str.charAt(0) - '0' <= 9) && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;

        StringBuilder result = new StringBuilder();
        int i = 0;

        if(str.charAt(0) == '+') {
            i++;
        }

        boolean isNegative = str.charAt(0) == '-';

        for(; i < str.length(); i++) {
            char ch = str.charAt(i);
            if((ch - '0' >= 0 && ch - '0' <= 9) || ch == '-'){
                result.append(ch);
                if(isNegative && result.length() >= 11) {
                    long temp = Long.parseLong(result.toString());
                    if(temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                } else if(!isNegative && result.length() >= 10) {
                    long temp = Long.parseLong(result.toString());
                    if(temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }

        int pos = 0;
        while(pos < result.length() && (result.charAt(pos) == '0' || result.charAt(pos) == '-')) pos++;
        if(pos == result.length()) return 0;
        StringBuilder ans;
        if(isNegative) {
            ans = new StringBuilder("-");
        } else {
            ans = new StringBuilder();
        }
        return Integer.parseInt(ans.append(result.substring(pos, result.length())).toString());

    }
}
