public class Solution {
    public int numDistinct(String A, String B) {
        // return numDistinctRecursion(A, B, 0, 0);
        return numDistinctDP(A, B);
    }

    public int numDistinctRecursion(String A, String B, int firstIndex, int secondIndex) {

        if(firstIndex == A.length() && secondIndex == B.length()) return 1;
        if(firstIndex == A.length()) return 0;
        if(secondIndex == B.length()) return 1;

        if(A.charAt(firstIndex) == B.charAt(secondIndex)) {
            return numDistinctRecursion(A, B, firstIndex + 1, secondIndex + 1) +
                    numDistinctRecursion(A, B, firstIndex + 1, secondIndex);
        }

        else {
            return numDistinctRecursion(A, B, firstIndex + 1, secondIndex);
        }
    }

    public int numDistinctDP(String A, String B) {
        int[][] cache = new int[A.length()][B.length()];
        for(int[] temp : cache) {
            Arrays.fill(temp, -1);
        }

        return numDistinctDPHelper(A, B, 0, 0, cache);

    }

    public int numDistinctDPHelper(String A, String B, int i, int j, int[][] cache) {
        if(i == A.length() && B.length() == j) return 1;
        if(i == A.length()) return 0;
        if(j == B.length()) return 1;

        if(cache[i][j] == -1) {
            if(A.charAt(i) == B.charAt(j)) {
                cache[i][j] = numDistinctDPHelper(A, B, i + 1, j + 1, cache) + numDistinctDPHelper(A, B, i + 1, j, cache);
            } else {
                cache[i][j] = numDistinctDPHelper(A, B, i + 1, j, cache);
            }
        }

        return cache[i][j];
    }
}
