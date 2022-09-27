public class Solution {
    public String solve(ArrayList<Integer> arr) {
        if(arr.size() % 2 != 0) return "NO";
        if(arr.get(0) % 2 == 0 && arr.get(arr.size() - 1) % 2 == 0) return "YES";

        return "NO";
    }
}
