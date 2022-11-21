public class Solution {
    public int solve(int A, int B, int C) {
        if(A == 1) return Math.min(B, C);
        long low = Math.min(B, C);
        long high = (long)A * Math.min(B, C);

        int lcm = (B * C) / gcd_loop(B, C);

        while(low <= high) {
            long mid = low + (high - low) / 2;
            if(isSmaller(A, B, C, mid, lcm)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = low % (1000000000 + 7);

        return (int)low;
    }

    public boolean isSmaller(int A, int B, int C, long mid, int lcm) {
        return (mid / B) + (mid / C) - (mid / lcm) < A;
    }

    public int gcd(int x, int y) {
        if(y == 0) return x;
        return gcd(y, x % y);
    }

    public int gcd_loop(int x, int y) {
        while(y > 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }

        return x;
    }
}
