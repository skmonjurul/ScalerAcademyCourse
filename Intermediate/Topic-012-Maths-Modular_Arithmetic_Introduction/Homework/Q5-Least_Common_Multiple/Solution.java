public class Solution {
    public int LCM(int a, int b) {
        return (a * b) / gcd(a, b);
    }


    public static int gcd(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        if(a == b) return a;

        if(a > b){
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }
}
