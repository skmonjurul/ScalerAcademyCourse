public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int sum = 0, i = 0, j = 0;
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();



        while(i < n) {
            if(sum == B) {
                for(int k = i; k < j; k++) {
                    result.add(A.get(k));
                }
                return result;
            } else if(j < n && sum < B) {
                sum += A.get(j);
                j++;
            } else {
                sum -= A.get(i);
                i++;
            }

        }


        result.add(-1);
        return result;
    }
}
