public class Solution {
    public int isInterleave(String A, String B, String C) {
        if(A.length() + B.length() != C.length()) return 0;

        // return isInterleave(A, B, C, 0, 0, 0) ? 1 : 0;

        return isInterleaveBottomUp(A, B, C);
    }

    public boolean isInterleave(String A, String B, String C, int index1, int index2, int index3) {

        if(index1 == A.length() && index2 == B.length()) return index3 == C.length();

        if(index3 == C.length()) return false;

        boolean answer = false;

        if(index1 < A.length() && A.charAt(index1) == C.charAt(index3)) {
            answer = answer || isInterleave(A, B, C, index1 + 1, index2, index3 + 1);
        }

        if(index2 < B.length() && B.charAt(index2) == C.charAt(index3)) {
            answer = answer || isInterleave(A, B, C, index1, index2 + 1, index3 + 1);
        }

        return answer;
    }

    public int isInterleaveBottomUp(String A, String B, String C) {
        int nA = A.length();
        int nB = B.length();

        int[][] interleaving = new int[nA + 1][nB + 1];

        for(int i = 0; i < nA + 1; i++) {
            for(int j = 0; j < nB + 1; j++) {
                if(i == 0 && j == 0) interleaving[i][j] = 1;

                else if(i == 0 && B.charAt(j - 1) == C.charAt(j - 1)) interleaving[i][j] = interleaving[i][j - 1];

                else if(j == 0 && A.charAt(i - 1) == C.charAt(i - 1)) interleaving[i][j] = interleaving[i - 1][j];

                else if(i > 0 && j > 0 && A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1)) interleaving[i][j] = interleaving[i - 1][j];

                else if(i > 0 && j > 0 && A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) interleaving[i][j] = interleaving[i][j - 1];

                else if(i > 0 && j > 0 && A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) interleaving[i][j] = interleaving[i - 1][j] | interleaving[i][j - 1];
            }
        }

        return interleaving[nA][nB];
    }
}
