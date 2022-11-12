public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
        Collections.sort(A);
        return A.get(B - 1);
    }
}
