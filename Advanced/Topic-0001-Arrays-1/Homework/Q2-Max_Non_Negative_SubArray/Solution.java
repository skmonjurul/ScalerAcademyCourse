public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> arr) {
        long max = Long.MIN_VALUE;
        long sum = 0;

        int start = -1;
        int end = -1;
        int negativeIndex = -1;
        int i;
        boolean isPositiveFound = false;

        for(i=0; i<arr.size(); i++) {
            int num = arr.get(i);

            if(num < 0 && isPositiveFound) {
                if(sum > max) {
                    max = sum;
                    start = negativeIndex + 1;
                    end = i - 1;
                }
                sum = 0;
                negativeIndex = i;
                isPositiveFound = false;
                continue;
            }
            if(num >= 0) {
                isPositiveFound = true;
                sum += num;
            }
            if(num < 0) {
                negativeIndex = i;
            }

        }

        ArrayList<Integer> result = new ArrayList<>();

        if(sum >= 0) {
            if(sum > max) {
                max = sum;
                start = negativeIndex + 1;
                end = i - 1;
            }
        }

        for(i=start; i<=end; i++) {
            result.add(arr.get(i));
        }

        return result;
    }
}
