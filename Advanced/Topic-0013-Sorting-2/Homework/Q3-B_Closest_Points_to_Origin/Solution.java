public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        A.sort((list1, list2) -> {
            Long first = squarePlus(list1.get(0), list1.get(1));
            Long second = squarePlus(list2.get(0), list2.get(1));
            return first.compareTo(second);
        });
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= B; i++) {
            result.add(A.get(i - 1));
        }

        return result;
    }

    public static long squarePlus(long x, long y) {
        return x * x + y * y;
    }
}
