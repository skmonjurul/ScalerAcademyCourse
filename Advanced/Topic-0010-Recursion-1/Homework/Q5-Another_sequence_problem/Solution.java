public class Solution {
    public int solve(int A) {
        if(A == 0) return A + 1;
        if(A == 1) return A;
        if(A == 2) return A;
        return A + solve(A - 1) + solve(A - 2) + solve(A - 3);
    }
}
