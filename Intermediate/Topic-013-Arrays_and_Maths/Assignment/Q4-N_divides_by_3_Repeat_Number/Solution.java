public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {

        if(a.size() == 1) return a.get(0);

        Map<Integer, Integer> frequency = new HashMap<>();

        int checkNumber = a.size() / 3;

        for(Integer num : a) {
            if(frequency.containsKey(num)) {
                if(frequency.get(num) + 1 > checkNumber) return num;
                else frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }

        return - 1;
    }
}
