public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> arr) {

        int row = arr.size();
        int column = arr.get(0).size();

        int[][] temp = new int[column][row];

        for(int i = 0; i<column; i++) {
            for(int j = 0; j<row; j++) {
                temp[i][j] = arr.get(j).get(i);
            }
        }

        ArrayList<ArrayList<Integer>> trans = new ArrayList<>();

        for(int i = 0; i<column; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j = 0; j<row; j++) {
                tmp.add(temp[i][j]);
            }
            trans.add(tmp);
        }

        return trans;

    }
}
