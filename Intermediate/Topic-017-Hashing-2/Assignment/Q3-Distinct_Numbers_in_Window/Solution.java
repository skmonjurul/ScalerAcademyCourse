public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> arr, int B) {

        ArrayList<Integer> distinctElements = new ArrayList<>();
        if(B > arr.size()) return distinctElements;

        Map<Integer, Integer> elementsWithCount = new HashMap<>();
        for(int i = 0; i<B; i++) {
            int value = elementsWithCount.getOrDefault(arr.get(i), 0);
            elementsWithCount.put(arr.get(i), value + 1);
        }

        distinctElements.add(elementsWithCount.size());

        for(int i=B; i < arr.size(); i++) {
            int subValue = elementsWithCount.getOrDefault(arr.get(i - B), 0);
            if(subValue > 1) {
                elementsWithCount.put(arr.get(i - B), subValue - 1);
            } else if(subValue == 1) {
                elementsWithCount.remove(arr.get(i - B));
            }
            int SumValue = elementsWithCount.getOrDefault(arr.get(i), 0);
            elementsWithCount.put(arr.get(i), SumValue + 1);
            distinctElements.add(elementsWithCount.size());
        }

        return distinctElements;
    }
}
