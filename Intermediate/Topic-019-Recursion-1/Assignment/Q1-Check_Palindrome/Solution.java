public class Solution {
    public int solve(String str) {
        return isPalindrome(str, 0, str.length() - 1);
    }

    public int isPalindrome(String str, int start, int end) {
        if(start > end) {
            return 1;
        }

        if(str.charAt(start) != str.charAt(end)) return 0;
        return isPalindrome(str, start + 1, end - 1);
    }
}
