public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> arr, int B) {
        Map<Integer, Integer> elementsWithIndex = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < arr.size(); i++) {
            int diff = B - arr.get(i);
            if(elementsWithIndex.containsKey(diff)) {
                result.add(elementsWithIndex.get(diff) + 1);
                result.add(i + 1);
                return result;
            } else if(elementsWithIndex.containsKey(arr.get(i))) {
                continue;
            }
            elementsWithIndex.put(arr.get(i), i);
        }

        return result;
    }
}
