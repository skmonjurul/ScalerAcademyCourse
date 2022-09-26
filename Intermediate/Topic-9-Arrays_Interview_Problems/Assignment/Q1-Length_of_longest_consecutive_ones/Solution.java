public class Solution {
    public int solve(String str) {
        int foundOne = 0;
        int total = 0;
        int max = Integer.MIN_VALUE;
        int temp = 0;


        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '1') {
                foundOne++;
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }

        max = Math.max(max, temp);

        for(int i=1; i<str.length() - 1; i++) {
            if(str.charAt(i) == '0') {
                int j = i - 1;
                int k = i + 1;

                int leftCount = 0, rightCount = 0;
                while(j >= 0) {
                    if(str.charAt(j) == '0') break;
                    leftCount++;
                    j--;
                }

                while(k < str.length()) {
                    if(str.charAt(k) == '0') break;
                    rightCount++;
                    k++;
                }

                total = leftCount + rightCount;
                if(total < foundOne) {
                    max = Math.max(max, total + 1);
                } else {
                    max = Math.max(max, total);
                }
            }
        }
        return max;
    }
}
