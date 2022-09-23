public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> arr) {

        int row = arr.size();
        int column = arr.get(0).size();
        ArrayList<Integer> columnSum = new ArrayList<>();

        for(int i = 0; i< column; i++) {
            int sum = 0;
            for(int j = 0; j< row; j++) {
                sum += arr.get(j).get(i);
            }
            columnSum.add(sum);
        }

        return columnSum;
    }
}
