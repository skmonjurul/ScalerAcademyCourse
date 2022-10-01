public class Solution {
    public int solve(int a, int b, int c) {
        int max = 0, min = 0, mid = 0;
        if(a >= b && a >= c) {
            max = a;
            if(b > c) {
                mid = b;
                min = c;
            } else {
                mid = c;
                min = b;
            }
        } else if(b >= a && b >= c) {
            max = b;
            if(a > c) {
                mid = a;
                min = c;
            } else {
                mid = c;
                min = a;
            }
        } else if(c >= a && c >= b) {
            max = c;
            if(a > b) {
                mid = a;
                min = b;
            } else {
                mid = b;
                min = a;
            }
        }


        return min * 10000 + mid * 100 + max;
    }
}
