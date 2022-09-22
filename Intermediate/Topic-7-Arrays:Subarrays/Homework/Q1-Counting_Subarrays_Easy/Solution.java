public class Solution {
    public int solve(ArrayList<Integer> arr, int b) {
        int n = arr.size();
        int count = 0;
        for(int i = 0; i< n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr.get(j);
                if(sum < b) {
                    count++;
                }
            }
        }

        return count;
    }
}
