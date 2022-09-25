public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> arr) {
        int row = arr.size();
        int column = arr.get(0).size();


        ArrayList<ArrayList<Integer>> temp = new ArrayList<>(row);
        for(int i = 0; i<row; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for(int j = 0; j<column; j++) {
                a.add(null);
            }
            temp.add(a);
        }


        for(int i = 0; i< row; i++) {
            for(int j = 0; j<column; j++) {
                if(arr.get(i).get(j) == 0) {
                    for(int k = 0; k < column; k++) {
                        temp.get(i).set(k, 0);
                    }

                    for(int k = 0; k<row; k++) {
                        temp.get(k).set(j, 0);
                    }
                }
            }
        }


        for(int i = 0; i<row; i++) {
            for(int j = 0; j<column; j++) {
                if(temp.get(i).get(j) == null) {
                    temp.get(i).set(j, arr.get(i).get(j));
                }
            }
        }

        return temp;



    }
}
