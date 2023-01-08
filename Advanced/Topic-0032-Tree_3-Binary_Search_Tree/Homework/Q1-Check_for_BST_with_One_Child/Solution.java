public class Solution {
    public String solve(int[] A) {
        if(A.length == 1 || A.length == 2) return "YES";
        return checkBST(A, 0).isPossible ? "YES" : "NO";
    }

    public Possible checkBST(int[] A, int index) {
        if(index == A.length - 1) {
            Possible Possible = new Possible();
            Possible.isPossible = true;
            Possible.min = A[index];
            Possible.max = A[index];
            return Possible;
        }

        Possible possible = checkBST(A, index + 1);
        if(!possible.isPossible) return possible;

        if(A[index] <= possible.min || A[index] >= possible.max) {
            possible.min = Math.min(possible.min, A[index]);
            possible.max = Math.max(possible.max, A[index]);
        } else {
            possible.isPossible = false;
        }

        return possible;
    }
}

class Possible {
    boolean isPossible;
    int min;
    int max;
}
