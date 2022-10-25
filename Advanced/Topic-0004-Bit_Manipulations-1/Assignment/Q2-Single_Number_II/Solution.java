public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(Integer num : A) {
                if(isSetBit(num, i)) count++;
            }
            if(count % 3 != 0) {
                ans += 1 << i;
            }
        }

        return ans;
    }

    public boolean isSetBit(int num, int k) {
        return (num & (1 << k)) != 0;
    }
}
