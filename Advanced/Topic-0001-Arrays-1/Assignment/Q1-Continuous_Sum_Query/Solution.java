public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<A; i++) {
            result.add(0);
        }

        for(ArrayList<Integer> devotee : B) {
            int start = devotee.get(0) - 1;
            int end = devotee.get(1) - 1;
            int num = devotee.get(2);
            result.set(start, result.get(start) + num);
            if(end + 1 < A) {
                result.set(end + 1, result.get(end + 1) - num);
            }

        }

        for(int i = 1; i<A; i++) {
            result.set(i, result.get(i) + result.get(i - 1));
        }

        return result;
    }
}
