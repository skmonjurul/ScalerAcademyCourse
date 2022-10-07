public class Solution {
    public String longestPalindrome(String str) {
        if(str.length() == 1) return str;
        if(str.length() == 2) {
            if(str.charAt(0) == str.charAt(1)) return str;
            else return String.valueOf(str.charAt(0));
        }
        int max = Integer.MIN_VALUE;
        int subStart = -1, subEnd = -1;
        boolean isPresent = false;
        for(int i=0; i<str.length(); i++) {
            int left = i - 1;
            int right = i + 1;

            while(left >= 0 && right < str.length()) {
                if(str.charAt(left) != str.charAt(right)) break;
                left--;
                right++;
            }

            if(left != i - 1) {
                int total = (right - left) + 1;
                if(total > max) {
                    max = total;
                    subStart = left == -1 ? 0 : left + 1;
                    subEnd = right == str.length() ? str.length() : right;
                    isPresent = true;
                }
            }

            if(i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
                left = i - 1;
                right = i + 2;

                while (left >= 0 && right < str.length()) {
                    if(str.charAt(left) != str.charAt(right)) break;
                    left--;
                    right++;
                }

                if(left != i - 1) {
                    int total = (right - left) + 1;
                    if(total > max) {
                        max = total;
                        subStart = left == -1 ? 0 : left + 1;
                        subEnd = right == str.length() ? str.length() : right;
                        isPresent = true;
                    }
                } else {
                    int total = ((i + 1) - i) + 1;
                    if(total > max) {
                        max = total;
                        subStart = i;
                        subEnd = i + 2;
                        isPresent = true;
                    }
                }

            }

        }
        if(isPresent) {
            return str.substring(subStart, subEnd);
        }

        return str.substring(0, 1);
    }
}
