public class Solution {
    public int findAthFibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return findAthFibonacci(n-1) + findAthFibonacci(n-2);
    }
}
