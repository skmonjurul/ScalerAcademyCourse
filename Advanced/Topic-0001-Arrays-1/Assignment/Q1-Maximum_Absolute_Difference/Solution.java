public class Solution {
    public int maxArr(ArrayList<Integer> arr) {

        int maxAdd = Integer.MIN_VALUE, minAdd = Integer.MAX_VALUE;
        int maxSub = Integer.MIN_VALUE, minSub = Integer.MAX_VALUE;

        for(int i = 0; i < arr.size(); i++) {
            int add = arr.get(i) + i;
            int sub = arr.get(i) - i;

            maxAdd = Math.max(maxAdd, add);
            minAdd = Math.min(minAdd, add);

            maxSub = Math.max(maxSub, sub);
            minSub = Math.min(minSub, sub);
        }

        return Math.max((maxAdd - minAdd), (maxSub - minSub));
    }
}
