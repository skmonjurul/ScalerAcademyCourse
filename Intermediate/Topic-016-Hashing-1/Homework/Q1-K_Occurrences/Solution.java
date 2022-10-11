public class Solution {
    public int getSum(int A, int B, ArrayList<Integer> arr) {
        Map<Integer, Integer> number = new HashMap<>();

        for(Integer num : arr) {
            int value = number.getOrDefault(num, 0);
            number.put(num, value + 1);
        }

        int sum = 0;
        boolean isFound = false;
        for(Map.Entry<Integer, Integer> entry : number.entrySet()) {
            if(entry.getValue() == B) {
                isFound = true;
                sum += entry.getKey() % (Math.pow(10, 9) + 7);
            }
        }

        return isFound ? sum : -1;

    }
}
