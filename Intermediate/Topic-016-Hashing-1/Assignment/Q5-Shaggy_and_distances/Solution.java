public class Solution {
    public int solve(ArrayList<Integer> arr) {

        Map<Integer, Integer> number = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.size(); i++) {
            int value = number.getOrDefault(arr.get(i), 0);
            if(value == 0) {
                number.put(arr.get(i), i + 1);
            }
            else {
                int index = value;
                int minDistance = Math.abs((i + 1) - index);
                if(minDistance < min) {
                    min = minDistance;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
