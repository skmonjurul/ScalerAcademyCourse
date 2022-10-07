public class Solution {
    public int solve(ArrayList<Character> str) {

        for(Character ch : str) {
            int num = (int)ch;
            if(!(num >= 65 && num <= 90) && !(num >= 97 && num <= 122) && !(num >= 48 && num <= 57)) {
                return 0;
            }
        }

        return 1;
    }
}
