public class Solution {
    public int minCut(String A) {
        // return minCutRecursion(A, 0, A.length() - 1);
        return minCutBottomUp(A);
    }

    public int minCutRecursion(String A, int start, int end) {
        if(start >= end) return 0;

        int min = 0;

        if(A.charAt(start) == A.charAt(end)) {
            min = minCutRecursion(A, start + 1, end - 1);
        }

        else {
            int possible_1 = 1 + minCutRecursion(A, start + 1, end);
            int possible_2 = 1 + minCutRecursion(A, start, end - 1);

            min = Math.min(possible_1, possible_2);
        }

        return min;
    }

    public int minCutBottomUp(String A) {
        int n = A.length();

        boolean[][] palindrome = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) palindrome[i][j] = true;
                else if(j == i + 1) {
                    if(A.charAt(i) == A.charAt(j)) palindrome[i][j] = true;
                }
                else {
                    if(A.charAt(i) == A.charAt(j) && palindrome[i + 1][j - 1]) palindrome[i][j] = true;
                }
            }
        }





        int[] minCut = new int[n];
        Arrays.fill(minCut, Integer.MAX_VALUE);


        for(int i = 0; i < n; i++) {
            if(palindrome[0][i]) {
                minCut[i] = 0;
                continue;
            }

            for(int j = 0; j <= i; j++) {
                if(palindrome[j][i]) minCut[i] = Math.min(minCut[i], 1 + minCut[j - 1]);
            }

        }

        return minCut[n - 1];
    }
}
