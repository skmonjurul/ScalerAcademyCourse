public class Solution {
    public String solve(String A, String B) {

        //if A == B, then gcd will be the same number
        if(A.equals(B)) return A;

        // if not then we need to find gcd of A, A + 1, A + 2,.....B
        // any two consecutive number gcd is 1, and if 1 present then the whole list gcd will be 1
        String gcd = "1";
        return gcd;
    }
}
