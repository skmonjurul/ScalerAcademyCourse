public class Solution {

    public int solve(ArrayList<Integer> arr) {
        if(arr.size() == 1) return 1;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, smallestSize = Integer.MAX_VALUE;

        for(Integer num : arr) {
            if(num > max) max = num;
            if(num < min) min = num;
        }

        int minPos = -1, maxPos = -1;

        for(int i=0; i < arr.size(); i++) {
            if(arr.get(i) == min) minPos = i;
            if(arr.get(i) == max) maxPos = i;

            if(minPos > -1 && maxPos > -1) {
                int size = Math.abs(maxPos - minPos) + 1;
                smallestSize = Math.min(size, smallestSize);
            }
        }

        return smallestSize;

    }
}
