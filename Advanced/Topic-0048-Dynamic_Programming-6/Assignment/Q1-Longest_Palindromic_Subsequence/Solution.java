public class Solution {
    public int solve(String A) {
        // return longestPalindromeSubSequenceRecursion(A, 0, A.length() - 1);
        return longestPalindromeSubSequenceDP(A);
    }

    public int longestPalindromeSubSequenceRecursion(String A, int start, int end) {
        if(start > end) return 0;
        if(start == end) return 1;

        int max = Integer.MIN_VALUE;

        // if match
        if(A.charAt(start) == A.charAt(end)) {
            int match = 2 + longestPalindromeSubSequenceRecursion(A, start + 1, end - 1);
            max = Math.max(max, match);
        }

        // if not match
        int notMatch_1 = longestPalindromeSubSequenceRecursion(A, start + 1, end);
        int notMatch_2 = longestPalindromeSubSequenceRecursion(A, start, end - 1);

        max = Math.max(max, Math.max(notMatch_1, notMatch_2));

        return max;

    }

    public int longestPalindromeSubSequenceDP(String A) {
        int length = A.length();
        int[][] cache = new int[length][length];

        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return longestPalindromeSubSequenceDPHelper(A, 0, length - 1, cache);

    }

    public int longestPalindromeSubSequenceDPHelper(String A, int start, int end, int[][] cache) {
        if(start > end) return 0;
        if(start == end) return 1;


        if(cache[start][end] == -1) {

            int max = Integer.MIN_VALUE;

            // if match
            if(A.charAt(start) == A.charAt(end)) {
                int match = 2 + longestPalindromeSubSequenceDPHelper(A, start + 1, end - 1, cache);
                max = Math.max(max, match);
            }

            // if not match

            int notMatch_1 = longestPalindromeSubSequenceDPHelper(A, start + 1, end, cache);
            int notMatch_2 = longestPalindromeSubSequenceDPHelper(A, start, end - 1, cache);

            max = Math.max(max, Math.max(notMatch_1, notMatch_2));

            cache[start][end] = max;
        }

        return cache[start][end];
    }
}
