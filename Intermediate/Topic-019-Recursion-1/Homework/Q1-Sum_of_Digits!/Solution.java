public class Solution {
    public int solve(int A) {
        if(A == 0) return 0;
        int d = A % 10;
        return d + solve(A / 10);
    }
}
