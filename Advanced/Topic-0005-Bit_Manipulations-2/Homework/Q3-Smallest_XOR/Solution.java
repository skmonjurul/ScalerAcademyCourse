public class Solution {
    public int solve(int A, int B) {

        int x = A;
        int setBitsCount = 0;
        while(x != 0) {
            if((x & 1) == 1) {
                setBitsCount++;
            }
            x = x >> 1;
        }

        if(setBitsCount == B) {
            return A;
        }

        if(B < setBitsCount) {
            int i = 0;
            x = A;
            while(setBitsCount != B) {
                if((x & 1) == 1) {
                    A -= 1 << i;
                    setBitsCount--;
                }
                x = x >> 1;
                i++;
            }

            return A;
        }

        int i = 0;
        x = A;
        while(setBitsCount != B) {
            if((x & 1) == 0) {
                A += 1 << i;
                setBitsCount++;
            }
            x = x >> 1;
            i++;
        }

        return A;
    }
}
