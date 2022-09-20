public class Solution {
    public int solve(String str) {

        long len = str.length();
        int count = 0;

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o' ||
                    ch == 'U' || ch == 'u') {
                count += len - i;
            }
        }

        return count % 10003;
    }
}
