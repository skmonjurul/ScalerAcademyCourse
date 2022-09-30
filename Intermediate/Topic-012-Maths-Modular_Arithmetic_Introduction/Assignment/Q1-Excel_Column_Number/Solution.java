public class Solution {
    public int titleToNumber(String str) {
        int n = str.length();
        int ans = 0;
        int mul = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans += ((str.charAt(i) - 'A') + 1) * mul;
            mul = mul * 26;
        }

        return ans;
    }
}
