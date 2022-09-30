public class Solution {
    public int solve(String str) {
        int n = str.length();

        int mul = 1;
        int ans = 0;
        int i = n - 1;

        while(i >= 0 && i >= n - 3) {
            ans += str.charAt(i) * mul;
            mul *= 10;
            i--;
        }

        return ans % 8 == 0 ? 1 : 0;
    }
}
