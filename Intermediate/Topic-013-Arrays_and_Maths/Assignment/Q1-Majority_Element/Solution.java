public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> arr) {
        int elem = arr.get(0);
        int frequency = 1;

        for(int i=1; i<arr.size(); i++) {
            if(frequency == 0) {
                elem = arr.get(i);
                frequency++;
            }
            else if(arr.get(i) == elem) {
                frequency++;
            } else {
                frequency--;
            }
        }

        return elem;
    }
}
