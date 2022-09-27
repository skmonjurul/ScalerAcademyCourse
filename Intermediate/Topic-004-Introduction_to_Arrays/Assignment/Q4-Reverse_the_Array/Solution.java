public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> solve(final List<Integer> arr) {
        ArrayList<Integer> reverArr = new ArrayList<>();

        for(int i=arr.size()-1; i>=0; i--) {
            reverArr.add(arr.get(i));
        }

        return reverArr;
    }
}
