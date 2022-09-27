public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> arr, int b) {

        for(int i = 0; i<arr.size(); i++) {
            for(int j = 0; j<arr.get(0).size(); j++) {
                int num = arr.get(i).get(j);
                num *= b;
                arr.get(i).set(j, num);
            }
        }

        return arr;

    }
}
