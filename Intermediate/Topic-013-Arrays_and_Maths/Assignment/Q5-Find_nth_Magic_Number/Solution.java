public class Solution {
    public int solve(int n) {
        int prod = 1, sum = 0;

        while(n > 0) {
            prod *= 5;
            if((n & 1) == 1) sum += prod;
            n = n >> 1;
        }

        return sum;
    }
}
