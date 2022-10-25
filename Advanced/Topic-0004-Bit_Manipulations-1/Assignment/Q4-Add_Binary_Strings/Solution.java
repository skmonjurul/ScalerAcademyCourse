public class Solution {
    public String addBinary(String A, String B) {
        int i = A.length() - 1, j = B.length() - 1;
        int carry = 0;
        String ans = "";
        while(i >= 0 && j >= 0) {
            int a = Integer.parseInt(String.valueOf(A.charAt(i)));
            int b = Integer.parseInt(String.valueOf(B.charAt(j)));
            int total = a + b + carry;
            if(total == 2) {
                carry = 1;
                ans = "0" + ans;
            } else if(total > 2) {
                carry = 1;
                ans = "1" + ans;
            } else if(total == 0) {
                carry = 0;
                ans = "0" + ans;
            }
            else {
                carry = 0;
                ans = "1" + ans;
            }

            i--;
            j--;
        }

        if(j < 0) {
            while (i >= 0) {
                int a = Integer.parseInt(String.valueOf(A.charAt(i)));
                int total = a + carry;
                if(total == 2) {
                    carry = 1;
                    ans = "0" + ans;
                } else if(total == 0) {
                    carry = 0;
                    ans = "0" + ans;
                }
                else {
                    carry = 0;
                    ans = "1" + ans;
                }
                i--;
            }
        } else{
            while (j >= 0) {
                int b = Integer.parseInt(String.valueOf(B.charAt(j)));
                int total = b + carry;
                if(total == 2) {
                    carry = 1;
                    ans = "0" + ans;
                } else if(total == 0) {
                    carry = 0;
                    ans = "0" + ans;
                }
                else {
                    carry = 0;
                    ans = "1" + ans;
                }
                j--;
            }
        }

        if(carry == 1) {
            ans = "1" + ans;
        }
        return ans;
    }
}
