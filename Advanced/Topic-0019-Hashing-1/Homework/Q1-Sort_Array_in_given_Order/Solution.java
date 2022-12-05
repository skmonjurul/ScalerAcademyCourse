import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        ConcurrentMap<Integer, Integer> numbers= new ConcurrentHashMap<>();
        for(Integer num : A) {
            int value = numbers.getOrDefault(num, 0);
            numbers.put(num, value + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(Integer num : B) {
            if(numbers.containsKey(num)) {
                for(int i = 1; i <= numbers.get(num); i++) {
                    result.add(num);
                }

                numbers.remove(num);
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for(Integer num : numbers.keySet()) {
            for(int i = 1; i <= numbers.get(num); i++) {
                temp.add(num);
            }
        }

        Collections.sort(temp);
        result.addAll(temp);

        return result;
    }
}
