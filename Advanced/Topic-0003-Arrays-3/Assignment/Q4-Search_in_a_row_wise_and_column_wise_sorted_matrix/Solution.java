public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<A.size(); i++) {
            for(int j = 0; j<A.get(i).size(); j++) {
                if(A.get(i).get(j) == B) {
                    int ans = (i + 1) * 1009 + (j + 1);
                    min = Math.min(ans, min);
                }
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}
