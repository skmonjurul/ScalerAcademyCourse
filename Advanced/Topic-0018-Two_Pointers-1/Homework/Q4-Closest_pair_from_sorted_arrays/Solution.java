public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int i = 0, j = B.size() - 1;
        int minDiff = Integer.MAX_VALUE;
        int first = -1, second = -1;

        ArrayList<Integer> result = new ArrayList<>();

        while(i < A.size() && j >= 0) {
            int sum = A.get(i) + B.get(j);
            if(sum == C){
                result.add(A.get(i));
                result.add(B.get(j));
                return result;
            }
            else if(sum < C) {
                int diff = Math.abs(sum - C);
                if(diff <= minDiff){
                    if(i < first|| diff < minDiff) {
                        first = i;
                        second = j;
                    } else if(i == first && j < second) {
                        second = j;
                    }
                }
                minDiff = Math.min(minDiff, diff);
                i++;
            } else {
                int diff = Math.abs(sum - C);
                if(diff <= minDiff){
                    if(i < first || diff < minDiff) {
                        first = i;
                        second = j;
                    } else if(i == first && j < second) {
                        second = j;
                    }
                }
                minDiff = Math.min(minDiff, diff);
                j--;
            }
        }

        result.add(A.get(first));
        result.add(B.get(second));

        return result;
    }
}
