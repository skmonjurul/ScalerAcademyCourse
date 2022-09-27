public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> arr1, ArrayList<ArrayList<Integer>> arr2) {


        int firstRow = arr1.size();
        int firstColumn = arr1.get(0).size();


        int secondRow = arr2.size();
        int secondColumn = arr2.get(0).size();


        int resultRow = firstRow;
        int resultColumn = secondColumn;


        ArrayList<ArrayList<Integer>> multi = new ArrayList<>();



        for(int i = 0; i<resultRow; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j<resultColumn; j++) {
                int p = 0, q = 0, sum = 0;

                while(p < firstColumn && q < secondRow) {
                    sum += arr1.get(i).get(p) * arr2.get(q).get(j);
                    p++;
                    q++;
                }

                temp.add(sum);
            }

            multi.add(temp);
        }

        return multi;

    }
}
