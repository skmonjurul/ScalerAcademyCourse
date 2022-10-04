public class Solution {
    public int solve(ArrayList<Integer> arr) {
        if(arr.size() == 2) return 1;
        Collections.sort(arr);
        int diff = arr.get(1) - arr.get(0);

        for(int i = 2; i < arr.size(); i++) {
            if(arr.get(i) - arr.get(i - 1) != diff) return 0;
        }

        return 1;


    }
}
