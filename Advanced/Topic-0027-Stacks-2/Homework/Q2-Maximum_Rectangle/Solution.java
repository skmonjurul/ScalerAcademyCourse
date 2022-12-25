public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        //for row count

        for(int rowNumber = 0; rowNumber < A.size(); rowNumber++) {
            ArrayList<Integer> row = new ArrayList<>(A.get(rowNumber));
            stack.clear();
            //add one zero at the last in each row
            row.add(0);
            for(int i = 0; i < row.size(); i++) {

                if(rowNumber > 0) {
                    //if value is zero then check the stack is empty or not
                    // if empty then continue, otherwise calculate the size
                    if(row.get(i) == 0) {
                        //pop element untill stack is empty
                        while(!stack.isEmpty()) {
                            int index = stack.pop();
                            //calculation
                            //the index you got fetch the element from that index
                            //distance = current index - (fetched index - 1) - 1
                            //calculate the value = distance * fetched value from index
                            // that is your area of rectengle
                            //using Math.max find the max
                            ans = Math.max(ans, (i - (index - 1) - 1) * row.get(index));
                        }
                    } else {
                        int setNumber = row.get(i) + A.get(rowNumber - 1).get(i);
                        int index = -1;
                        while(!stack.isEmpty() && row.get(stack.peek()) > setNumber) {
                            index = stack.pop();
                            ans = Math.max(ans, (i - (index - 1) - 1) * row.get(index));
                            row.set(index, setNumber);
                        }
                        for(int j = index; index > -1 && j < i; j++) {
                            stack.push(j);
                        }

                        //first add the above cell value, set the value in current row
                        row.set(i, setNumber);
                        A.get(rowNumber).set(i, setNumber);
                        //push the index into stack
                        stack.push(i);
                    }
                }
                //for the first row
                else {
                    //if value is zero then check the stack is empty or not
                    // if empty then continue, otherwise calculate the size
                    if(row.get(i) == 0) {
                        //pop element untill stack is empty
                        while(!stack.isEmpty()) {
                            int index = stack.pop();
                            //calculation
                            //the index you got fetch the element from that index
                            //distance = current index - (fetched index - 1) - 1
                            //calculate the value = distance * fetched value from index
                            // that is your area of rectengle
                            //using Math.max find the max
                            ans = Math.max(ans, (i - (index - 1) - 1) * row.get(index));
                        }
                        // continue;
                    }
                    // if value is 1 then push the index to stack
                    else {
                        stack.push(i);
                    }
                }
            }
        }

        return ans;
    }
}
