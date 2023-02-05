public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> A) {
        int[] maxCache = new int[A.size()];
        int[] minCache = new int[A.size()];
        maxCache[0] = A.get(0);
        minCache[0] = A.get(0);

        for(int i = 1; i < A.size(); i++) {
            maxCache[i] = Math.max(A.get(i) * minCache[i - 1], Math.max(A.get(i), A.get(i) * maxCache[i - 1]));
            minCache[i] = Math.min(A.get(i) * minCache[i - 1], Math.min(A.get(i), A.get(i) * maxCache[i - 1]));
        }

        int max = Integer.MIN_VALUE;

        for(int num : maxCache) {
            max = Math.max(max, num);
        }

        return max;
    }

    public int maxProduct(List<Integer> A, int index) {
        return 0;
    }
}
