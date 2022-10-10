public class Solution {
    public int solve(ArrayList<Integer> arr) {

        Map<Integer, Integer> number = new HashMap<Integer, Integer>();

        for(Integer num : arr) {
            int value = number.getOrDefault(num, 0);
            number.put(num, value + 1);
        }

        for(Integer num : arr) {
            int value = number.getOrDefault(num, 0);
            if(value > 1) {
                return num;
            }
        }

        return -1;
    }
}
