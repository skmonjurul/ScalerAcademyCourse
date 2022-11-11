public class Solution {
    public int solve(int A, int B) {
        return kthSymbol(A, B - 1);
    }

    public int kthSymbol(int row, int index) {
        if(row == 1) {
            return 0;
        }
        int result = kthSymbol(row - 1, index / 2);
        if(index % 2 == 0) {
            return result;
        }
        return result == 1 ? 0 : 1;
    }
}
