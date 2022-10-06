public class Solution {
    public String solve(String str) {
        str = str.trim();
        String[] words = str.split(" ");
        str = "";
        for(int i=0; i<words.length; i++) {
            if(i != 0) str = " " + str;
            str = words[i] + str;
        }

        return str;
    }
}
