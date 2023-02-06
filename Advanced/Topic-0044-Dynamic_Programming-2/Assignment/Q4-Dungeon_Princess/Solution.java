public class Solution {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int row = A.size(), column = A.get(0).size();
        int[] prev, current = new int[row];

        // check the last bottom right cell
        if(A.get(row - 1).get(column - 1) >= 0)
            current[row - 1] = 1;
        else
            current[row - 1] = Math.abs(A.get(row - 1).get(column - 1)) + 1;

        // for the last column
        for(int i = row - 2; i >= 0; i--) {
            if(A.get(i).get(column - 1) >= current[i + 1])
                // current[i] = A.get(i).get(column - 1);
                current[i] = 1;
            else
                current[i] = current[i + 1] - A.get(i).get(column - 1);
        }


        // for the remaining column from right to left
        for(int j = column - 2; j >= 0; j--) {
            prev = current;
            current = new int[row];
            for(int i = row - 1; i >= 0; i--) {
                if(i == row - 1){
                    if(A.get(i).get(j) >= prev[i])
                        current[i] = 1;
                    else
                        current[i] = prev[i] - A.get(i).get(j);
                }
                else {
                    int number = A.get(i).get(j);
                    if(number >= prev[i] && number >= current[i + 1])
                        current[i] = 1;
                    else if(number >= prev[i])
                        current[i] = 1;
                    else if(number >= current[i + 1])
                        current[i] = 1;
                    else
                        current[i] = Math.min(prev[i] - number, current[i + 1] - number);
                }
            }
        }

        return current[0];

    }
}
