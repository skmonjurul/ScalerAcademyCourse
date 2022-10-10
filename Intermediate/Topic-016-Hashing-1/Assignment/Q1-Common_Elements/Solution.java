public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> number = new HashMap<>();

        for(Integer num : A) {
            int value = number.getOrDefault(num, 0);
            number.put(num, value + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(Integer num : B) {
            int value = number.getOrDefault(num, 0);
            if(value > 0) {
                result.add(num);
                number.put(num, value - 1);
            }
        }

        return result;
    }
}
