public class Solution {
    public int bulbs(ArrayList<Integer> arr) {
        int count = 0;
        boolean rightSide = false;
        for(int i = 0; i<arr.size(); i++) {
            if(arr.get(i) == 0 && !rightSide) {
                count++;
                rightSide = true;
            }

            if(arr.get(i) == 1 && rightSide) {
                count++;
                rightSide = false;
            }
        }

        return count;
    }
}
