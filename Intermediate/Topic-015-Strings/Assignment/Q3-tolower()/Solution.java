public class Solution {
    public ArrayList<Character> to_lower(ArrayList<Character> str) {
        for(int i = 0; i < str.size(); i++) {
            int num = (int)str.get(i);
            if(num >= 65 && num <= 90) {
                num = num + 32;
                str.set(i, (char)num);
            }
        }

        return str;
    }
}
