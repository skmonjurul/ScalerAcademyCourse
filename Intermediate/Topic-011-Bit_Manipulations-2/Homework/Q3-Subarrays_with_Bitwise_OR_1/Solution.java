public class Solution {
    public Long solve(int A, ArrayList<Integer> arr) {

        Long count = 0L;
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) == 1) {
                count += arr.size() - i;
            } else {
                int nextIndex = i + 1;
                while(nextIndex < arr.size() && arr.get(nextIndex) != 1) {
                    nextIndex++;
                }
                count += arr.size() - nextIndex;
            }
        }

        return count;
    }
}
