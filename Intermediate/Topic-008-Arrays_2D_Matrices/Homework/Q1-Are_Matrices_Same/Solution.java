public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> arr1, ArrayList<ArrayList<Integer>> arr2) {
        int row = arr1.size();
        int column = arr1.get(0).size();


        for(int i = 0; i< row; i++) {
            for(int j = 0; j < column; j++) {
                if(arr1.get(i).get(j) != arr2.get(i).get(j)) return 0;
            }
        }

        return 1;
    }
}
