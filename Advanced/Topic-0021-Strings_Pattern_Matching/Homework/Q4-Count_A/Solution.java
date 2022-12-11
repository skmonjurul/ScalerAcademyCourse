public class Solution {
    public int solve(String A) {
        int i = 0;

        int count = 0;
        int oldLength = 0;

        while(i < A.length()) {
            if(A.charAt(i) == 'a') {
                int temp = i + 1;
                while(temp < A.length() && A.charAt(temp) == 'a') {
                    temp++;
                }

                int length = temp - i;
                count += (length * (length + 1)) / 2;
                count += oldLength * length;
                i = temp + 1;
                oldLength += length;
            } else {
                i++;
            }
        }


        return count;
    }
}
