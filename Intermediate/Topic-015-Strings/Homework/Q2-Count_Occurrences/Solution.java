public class Solution {
    public int solve(String str) {
        int occurence = 0;
        String bob = "bob";
        for(int i=0; i<str.length() - 2; i++) {
            if(str.charAt(i) == 'b') {
                if(str.substring(i, i + bob.length()).equals(bob)) occurence++;
            }
        }

        return occurence;
    }
}
