public class Solution {
    public int solve(int A) {
        if(A < 10) return A;
        return A % 10 + solve(A / 10);
    }
}
