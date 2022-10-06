public class Solution {
    public ArrayList<Character> to_upper(ArrayList<Character> str) {
        for(int i = 0; i<str.size(); i++) {
            int num = (int) str.get(i);
            if(num >= 97 && num <= 122) {
                num = num - 32;
                str.set(i, (char)num);
            }
        }
        return str;
    }
}
