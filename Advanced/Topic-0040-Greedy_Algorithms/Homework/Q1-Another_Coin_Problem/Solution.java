public class Solution {
    public int solve(int A) {
        int i;
        // check what is the maximum denomination needed for value A
        for(i = 1; i <= A; i *= 5) {}

        // in above loop, we will get one the denomination = required maximum denomination * 5;
        // so we need to divide by 5 to get the required maximum denomination
        i /= 5;


        int count = 0;

        while(A > 0) {
            // check how many coins required with the denomination
            count += A / i;
            //remaining money need to pay
            A %= i;
            // need to shift smaller denomination / coin
            i /= 5;
        }

        return count;
    }
}
