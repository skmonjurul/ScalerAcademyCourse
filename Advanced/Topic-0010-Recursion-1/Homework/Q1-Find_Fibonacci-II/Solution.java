public class Solution {
    public int findAthFibonacci(int A) {
        int a = 0, b = 1;
        while(A > 0) {
            int temp = a;
            a = b;
            b = b + temp;
            A--;
        }

        return a;

    }
}
