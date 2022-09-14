public class Solution {
    public int solve(ArrayList<Integer> arr, int b) {
        int count = 0;
        boolean isPresent = false;
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) == b) isPresent = true;
            if(arr.get(i) > b) count++;
        }

        if(isPresent) return count;
        return -1;
    }
}
