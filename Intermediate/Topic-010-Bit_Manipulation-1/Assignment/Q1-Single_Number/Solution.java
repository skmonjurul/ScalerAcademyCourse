public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int ans = 0;
        for(Integer num : A) {
            ans = ans ^ num;
        }

        return ans;
    }
}
