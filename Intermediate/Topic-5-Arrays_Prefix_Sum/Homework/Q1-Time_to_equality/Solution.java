public class Solution {
    public int solve(ArrayList<Integer> arr) {

        int max = Integer.MIN_VALUE;

        for(int i = 0; i<arr.size(); i++) {
            if(arr.get(i) > max) max = arr.get(i);
        }

        int sum = 0;
        for(int i = 0; i< arr.size(); i++) {
            sum += (max - arr.get(i));
        }

        return sum;
    }
}
