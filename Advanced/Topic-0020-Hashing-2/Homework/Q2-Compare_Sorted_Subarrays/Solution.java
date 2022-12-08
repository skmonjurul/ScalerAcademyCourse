public class Solution {

    public int generateRandom() {
        Random random = new Random();
        return random.nextInt();
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, Integer> numberWithRandomNumber = new HashMap<>();

        long[] prefixSum = new long[A.size()];
        long sum = 0;
        for(int i = 0; i < A.size(); i++) {
            if(numberWithRandomNumber.containsKey(A.get(i))) continue;
            numberWithRandomNumber.put(A.get(i), generateRandom());
        }

        for(int i = 0; i < A.size(); i++) {
            sum += numberWithRandomNumber.get(A.get(i));
            prefixSum[i] = sum;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(ArrayList<Integer> query : B) {
            int l1 = query.get(0);
            int r1 = query.get(1);

            int l2 = query.get(2);
            int r2 = query.get(3);
            // numberWithFrequency.clear();

            if(l1 == l2 && r1 == r2) {
                result.add(1);
                continue;
            }
            if((r1 - l1 + 1) != (r2 - l2 + 1)) {
                result.add(0);
                continue;
            }

            long firstRangeSum = l1 == 0 ? prefixSum[r1] : prefixSum[r1] - prefixSum[l1 - 1];
            long secondRangeSum = l2 == 0 ? prefixSum[r2] : prefixSum[r2] - prefixSum[l2 - 1];

            if(firstRangeSum == secondRangeSum) {
                result.add(1);
            } else {
                result.add(0);
            }

            // for(int i = l1; i <= r1; i++) {
            //     int value = numberWithFrequency.getOrDefault(A.get(i), 0);
            //     numberWithFrequency.put(A.get(i), value + 1);
            // }

            // for(int i = l2; i <= r2; i++) {
            //     int value = numberWithFrequency.getOrDefault(A.get(i), 0);
            //     numberWithFrequency.put(A.get(i), value + 1);
            // }

            // boolean same = true;
            // for(Integer key : numberWithFrequency.keySet()) {
            //     if(numberWithFrequency.get(key) % 2 != 0) {
            //         same = false;
            //         break;
            //     }
            // }


            // result.add(same ? 1 : 0);
        }

        return result;
    }
}
