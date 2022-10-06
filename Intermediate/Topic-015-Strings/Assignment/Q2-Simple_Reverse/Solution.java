public class Solution {
    public String solve(String str) {
        char[] allChar = str.toCharArray();
        int i = 0, j = allChar.length - 1;

        while(i < j) {
            char temp = allChar[i];
            allChar[i] = allChar[j];
            allChar[j] = temp;
            i++;
            j--;
        }

        return new String(allChar);
    }
}
