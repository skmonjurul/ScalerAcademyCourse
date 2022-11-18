public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int pow = (int) (Math.pow(10, 9) + 7);
        long max = 0, min = 0;
        int n = A.size();
        for(int i = 0; i < n / 2; i++) {
            max += Math.abs((long)A.get(n - i - 1) - A.get(i));
        }

        for(int i = 0; i < n && n > 1; i += 2) {
            min += Math.abs((long)A.get(i + 1) - A.get(i));
        }

        ArrayList<Integer> result = new ArrayList<>();
        max = (max + pow) % pow;
        min = (min + pow) % pow;
        result.add((int)max);
        result.add((int)min);

        return result;
    }
}
