public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        for(int i = row - 2; i >= 0; i--) {
            int column = A.get(i).size();
            for(int j = 0; j < column; j++) {
                int number = A.get(i).get(j);
                int min = Math.min(number + A.get(i + 1).get(j), number + A.get(i + 1).get(j + 1));
                A.get(i).set(j, min);
            }
        }

        return A.get(0).get(0);
    }

    // public int minimumTotal(ArrayList<ArrayList<Integer>> a, int row) {
    //     if(row >= a.size()) return 0;

    //     int min = Integer.MAX_VALUE;

    //     for(int i = 0; i < a.get(row).size(); i++) {
    //         min = Math.min(min, a.get(row).get(i));
    //     }

    //     return min + minimumTotal(a, row + 1);
    // }
}
