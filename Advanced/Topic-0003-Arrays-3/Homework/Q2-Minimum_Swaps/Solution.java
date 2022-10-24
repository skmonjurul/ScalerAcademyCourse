public class Solution {
    public int solve(ArrayList<Integer> arr, int B) {

        int smallNumberCount = 0;
        for(Integer num : arr) {
            if(num <= B) {
                smallNumberCount++;
            }
        }
        int min = Integer.MAX_VALUE, badNumber = 0;
        for(int i = 0; i < smallNumberCount; i++) {
            if(arr.get(i) > B){
                badNumber++;
            }
        }

        min = Math.min(min, badNumber);
        for(int i = 1; i<= arr.size() - smallNumberCount; i++) {
            if(arr.get(i-1) > B) {
                badNumber--;
            }
            if(arr.get(i + smallNumberCount - 1) > B) {
                badNumber++;
            }

            min = Math.min(min, badNumber);
        }

        return min;


    }
}
