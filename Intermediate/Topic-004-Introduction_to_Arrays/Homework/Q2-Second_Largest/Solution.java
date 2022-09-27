public class Solution {
    public int solve(ArrayList<Integer> arr) {

        if(arr.size() == 1) return -1;

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int maxPos = 0;
        for(int i=0; i < arr.size(); i++) {
            if(i == 0) {
                if(arr.get(i) > max) {
                    max = arr.get(i);
                }
            }

            if(arr.get(i) > max) {
                secondMax = max;
                max = arr.get(i);
            } else if(arr.get(i) > secondMax) {
                secondMax = arr.get(i);
            }
        }

        return secondMax;
    }
}
