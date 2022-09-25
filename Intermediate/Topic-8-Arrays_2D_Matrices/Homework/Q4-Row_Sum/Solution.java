public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<Integer> rowSum = new ArrayList<>();

        for(int i = 0; i<arr.size(); i++) {
            int sum = 0;
            for(int j = 0; j< arr.get(0).size(); j++) {
                sum += arr.get(i).get(j);
            }

            rowSum.add(sum);
        }

        return rowSum;
    }
}
