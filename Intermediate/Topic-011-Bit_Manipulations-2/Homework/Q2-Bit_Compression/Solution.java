public class Solution {
    public int compressBits(ArrayList<Integer> arr) {

        int ans = 0;

        for(int i = 0; i<arr.size() - 1; i++) {
            int current = arr.get(i);
            int next = arr.get(i + 1);
            arr.set(i, current & next);
            arr.set(i+1, current | next);
            ans = ans ^ arr.get(i);
        }

        return ans ^ arr.get(arr.size() - 1);
    }
}
