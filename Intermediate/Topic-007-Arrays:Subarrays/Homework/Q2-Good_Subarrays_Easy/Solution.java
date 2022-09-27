public class Solution {
    public int solve(ArrayList<Integer> arr, int b) {

        int count = 0;

        for(int i=0; i<arr.size(); i++) {
            int sum = 0;
            for(int j=i; j<arr.size(); j++) {
                sum += arr.get(j);
                if(((j - i) + 1) % 2 == 0) {
                    if(sum < b) count++;
                } else {
                    if(sum > b) count++;
                }
            }
        }

        return count;


    }
}
