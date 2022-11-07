public class Solution {
    public int solve(int A) {
        if(A == 0) return 1;
        return A * solve(A - 1);
    }
}
