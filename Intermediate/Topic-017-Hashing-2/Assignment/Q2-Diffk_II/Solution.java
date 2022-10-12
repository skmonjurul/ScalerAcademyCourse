public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> arr, int B) {
        Set<Integer> elements = new HashSet<>();

        for(int i=0; i < arr.size(); i++) {
            int diff = arr.get(i) - B;
            int sum = arr.get(i) + B;
            if(elements.contains(diff) || elements.contains(sum)) {
                return 1;
            }
            elements.add(arr.get(i));
        }

        return 0;
    }
}
