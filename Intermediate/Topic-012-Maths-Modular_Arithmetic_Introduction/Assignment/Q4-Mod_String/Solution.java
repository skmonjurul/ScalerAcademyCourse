public class Solution {
    public int findMod(String str, int b) {
        int n = str.length();
        long ans = 0;
        long mul = 1L;
        long mod = b;

        for(int i = n - 1; i >= 0; i--) {
            int digit = (int)str.charAt(i) - '0';
            ans = (ans + (digit * mul % mod) % mod) % mod;
            mul = (mul * 10) % mod;
        }

        return (int)ans;
    }
}
