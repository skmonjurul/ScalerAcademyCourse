public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();

        if(B > A.size()) return result;
        if(B == 1) {
            for(int i = 1; i <= A.size(); i++) {
                result.add(1);
            }

            return result;
        }

        Map<Integer, Integer> distinctNumber = new HashMap<>();
        for(int i = 0; i < B; i++) {
            int value = distinctNumber.getOrDefault(A.get(i), 0);
            distinctNumber.put(A.get(i), value + 1);
        }

        result.add(distinctNumber.size());
        for(int i = B; i < A.size(); i++) {
            if(distinctNumber.containsKey(A.get(i - B))) {
                int value = distinctNumber.get(A.get(i - B));
                if(value > 1) {
                    distinctNumber.put(A.get(i - B), value - 1);
                } else {
                    distinctNumber.remove(A.get(i - B));
                }
            }

            //add the value in hashMap
            int value = distinctNumber.getOrDefault(A.get(i), 0);
            distinctNumber.put(A.get(i), value + 1);
            result.add(distinctNumber.size());
        }

        return result;
    }
}
