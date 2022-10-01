public class Solution {
    public int solve(int a) {
        if((a % 400 == 0) || (a % 4 == 0 && a % 100 != 0)){
            return 1;
        } else {
            return 0;
        }
    }
}
