public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        int firstStart = 0, firstEnd = A.size() - 1, secondStart = 0, secondEnd = B.size() - 1;

        ArrayList<Integer> merged = new ArrayList<>();

        while(firstStart <= firstEnd && secondStart <= secondEnd) {
            if(A.get(firstStart) < B.get(secondStart)) {
                merged.add(A.get(firstStart));
                firstStart++;
            } else {
                merged.add(B.get(secondStart));
                secondStart++;
            }
        }

        while(firstStart <= firstEnd) {
            merged.add(A.get(firstStart));
            firstStart++;
        }

        while(secondStart <= secondEnd) {
            merged.add(B.get(secondStart));
            secondStart++;
        }

        return merged;
    }
}
