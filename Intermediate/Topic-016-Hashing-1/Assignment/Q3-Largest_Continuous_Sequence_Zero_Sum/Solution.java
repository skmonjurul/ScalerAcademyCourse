public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> arr) {


        if(arr.size() == 1 && arr.get(0) == 0) return arr;

        int sum = 0, max = Integer.MIN_VALUE;
        int startIndex = -1, endIndex = -1;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        for(int i=0; i<arr.size(); i++) {
            sum += arr.get(i);
            if(sum == 0) {
                int diff = i + 1;
                if(diff > max) {
                    max = diff;
                    endIndex = i;
                    startIndex = 0;
                }
            }


            if(prefixSum.containsKey(sum)) {
                int diff = i - (prefixSum.get(sum) + 1) + 1;
                if(diff > max) {
                    max = diff;
                    endIndex = i;
                    startIndex = prefixSum.get(sum) + 1;
                }
            } else {
                prefixSum.put(sum, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if(startIndex > -1) {
            for(int i = startIndex; i <= endIndex; i++) {
                result.add(arr.get(i));
            }
        }

        return result;
    }
}
