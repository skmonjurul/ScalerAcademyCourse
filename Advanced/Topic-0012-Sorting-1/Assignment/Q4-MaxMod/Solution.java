public class Solution {
    public int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for(Integer num : A) {
            if(num > max) {
                secondMax = max;
                max = num;
            } else if(num > secondMax && num != max) {
                secondMax = num;
            }
        }

        if(secondMax == Integer.MIN_VALUE) return 0;
        return secondMax % max;
    }
}
