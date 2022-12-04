public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Long, Integer> firstSeen = new HashMap<>();

        firstSeen.put(0L, -1);

        int maxLength = Integer.MIN_VALUE;
        long sum = 0;
        int start = -1, end = -1;
        for(int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if(firstSeen.containsKey(sum)) {
                int length = i - firstSeen.get(sum);
                if(length > maxLength) {
                    start = firstSeen.get(sum) + 1;
                    end = i;
                }
                maxLength = Math.max(maxLength, length);
            } else {
                firstSeen.put(sum, i);
            }
        }


        ArrayList<Integer> result = new ArrayList<>();
        if(maxLength == Integer.MIN_VALUE) return result;

        for(int i = start; i <= end; i++) {
            result.add(A.get(i));
        }

        return result;
    }
}
