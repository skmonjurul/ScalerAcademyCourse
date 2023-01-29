public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        permutes(A, 0, result);

        return result;
    }

    public void permutes(ArrayList<Integer> A, int start, ArrayList<ArrayList<Integer>> result) {
        if(start == A.size() - 1) {
            result.add(new ArrayList<Integer> (A));
            return;
        }


        for(int i = start; i < A.size(); i++) {
            swap(A, i, start);
            permutes(A, start + 1, result);
            swap(A, i, start);
        }
    }

    public void swap(ArrayList<Integer> A, int second, int first) {
        int temp = A.get(first);
        A.set(first, A.get(second));
        A.set(second, temp);
    }
}
