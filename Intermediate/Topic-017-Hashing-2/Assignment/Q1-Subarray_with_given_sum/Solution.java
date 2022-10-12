public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> arr, int B) {

        Map<Long, Integer> elementWithIndex = new HashMap<>();
        long sum = 0;

        int startIndex = -1, endIndex = -1;

        for(int i = 0; i<arr.size(); i++) {
            sum += arr.get(i);
            long diff = sum - B;
            if(diff == 0) {
                startIndex = 0;
                endIndex = i;
                break;
            }
            if(elementWithIndex.containsKey(diff)) {
                startIndex = elementWithIndex.get(diff) + 1;
                endIndex = i;
                break;
            } else {
                elementWithIndex.put(sum, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        if(startIndex == -1) {
            result.add(-1);
            return result;
        }

        for(int i = startIndex; i<=endIndex; i++) {
            result.add(arr.get(i));
        }

        return result;
    }
}
