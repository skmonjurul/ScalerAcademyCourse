public class Solution {
    public ArrayList<Long> rangeSum(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> b) {
        long[] ps = new long[arr.size()];
        createPrefixArray(arr, ps);

        ArrayList<Long> output = new ArrayList<>();

        for(ArrayList<Integer> range : b) {
            long sum = 0L;
            int start = range.get(0) - 1;
            int end = range.get(1) - 1;

            if(start == 0) {
                sum = ps[end];
            } else {
                sum = ps[end] - ps[start - 1];
            }
            output.add(sum);
        }

        return output;
    }


    public void createPrefixArray(ArrayList<Integer> arr, long[] ps) {
        for(int i=0; i<arr.size(); i++) {
            if(i == 0) {
                ps[i] = arr.get(i);
            } else {
                ps[i] = ps[i - 1] + arr.get(i);
            }
        }
    }
}
