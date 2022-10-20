public class Solution {
    public ArrayList<Integer> flip(String str) {

        ArrayList<Integer> result = new ArrayList<>();
        int[] prefix = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                prefix[i] = 1;
            } else {
                prefix[i] = -1;
            }
        }

        int start = -1, end = -1, starting = 0;

        int sum = 0, max = 0;
        for(int i=0; i < prefix.length; i++) {
            sum += prefix[i];
            if(sum > max) {
                start = starting + 1;
                end = i + 1;
                max = sum;
            }
            if(sum < 0) {
                sum = 0;
                starting = i + 1;
            }
        }
        if(start < 0) {
            return result;
        }
        result.add(start);
        result.add(end);

        return result;
    }
}
