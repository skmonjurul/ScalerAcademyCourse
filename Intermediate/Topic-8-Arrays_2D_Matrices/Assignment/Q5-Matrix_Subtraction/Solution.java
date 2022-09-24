public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> arr1, ArrayList<ArrayList<Integer>> arr2) {

        int row = arr1.size();
        int column = arr1.get(0).size();

        ArrayList<ArrayList<Integer>> minus = new ArrayList<>();

        for(int i = 0; i< row; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j<column; j++) {
                temp.add(arr1.get(i).get(j) - arr2.get(i).get(j));
            }

            minus.add(temp);
        }

        return minus;
    }
}
