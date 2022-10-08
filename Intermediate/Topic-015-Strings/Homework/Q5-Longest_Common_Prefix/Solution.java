public class Solution {
    public String solve(String str) {

        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                str = str.replace(str.charAt(i), '#');
            }
            int num = (int)str.charAt(i);
            if(num >= 65 && num <= 90) {
                str = str.substring(0, i) + str.substring(i+1);
                i--;
            }
        }
        return str + str;
    }
}
