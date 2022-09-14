public class Solution {
    public int solve(ArrayList<Integer> arr) {

        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for(int i=0; i < arr.size(); i++) {
            if(arr.get(i) % 2 == 0) {
                if(arr.get(i) > maxEven) {
                    maxEven = arr.get(i);
                }
            } else {
                if(arr.get(i) < minOdd) {
                    minOdd = arr.get(i);
                }
            }
        }

        return maxEven - minOdd;
    }
}
