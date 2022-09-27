public class Solution {

    public ArrayList<Integer> solve(ArrayList<Integer> arr) {

        int max = Integer.MIN_VALUE;
        ArrayList<Integer> leaders = new ArrayList<>();
        for(int i = arr.size() - 1; i >= 0; i--) {
            if(arr.get(i) > max) {
                max = arr.get(i);
                leaders.add(max);
            }
        }
        return leaders;
    }
}
