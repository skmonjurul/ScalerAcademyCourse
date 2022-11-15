public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int count = 0;

        for(int i=1; i < A.size(); i++) {
            if(Objects.equals(A.get(i), A.get(i - 1))) {
                count++;
                A.set(i, A.get(i) + 1);
            } else if(A.get(i) < A.get(i - 1)) {
                int excess = A.get(i - 1) + 1 - A.get(i);
                count += excess;
                A.set(i, A.get(i) + excess);
            }
        }

        return count;
    }
}
