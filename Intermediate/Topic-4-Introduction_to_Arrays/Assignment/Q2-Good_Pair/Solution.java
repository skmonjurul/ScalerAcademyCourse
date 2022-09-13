public class Solution {
    public int solve(ArrayList<Integer> arr, int b) {

        Map<Integer, Integer> numbers = new HashMap<>();
        for(int i: arr) {
            int diff = b - i;
            if(numbers.containsKey(diff)) return 1;
            numbers.put(i, 0);
        }
        numbers = null;
        return 0;
    }
}
