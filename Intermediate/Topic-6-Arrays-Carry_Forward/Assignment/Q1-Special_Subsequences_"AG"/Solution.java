public class Solution {
    public int solve(String str) {
        if(str == null) return 0;

        int count = 0;
        int aCount = 0;

        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i) == 'A') aCount++;
            if(str.charAt(i) == 'G') {
                count += aCount;
            }
        }

        return (int) (count % (Math.pow(10, 9) + 7));

    }
}
