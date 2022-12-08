public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> numbersWithFrequency = new HashMap<>();

        for(Integer num : A) {
            int value = numbersWithFrequency.getOrDefault(num, 0);
            numbersWithFrequency.put(num, value + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(Integer num : B) {
            int value = numbersWithFrequency.getOrDefault(num, 0);
            if(value > 0) {
                result.add(num);
                numbersWithFrequency.put(num, value - 1);
            }
        }


        return result;
    }
}
