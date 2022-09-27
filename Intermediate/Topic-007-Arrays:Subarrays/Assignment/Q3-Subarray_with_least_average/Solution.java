public class Solution {
    public int solve(ArrayList<Integer> arr, int b) {
        int n = arr.size();
        int[] ps = new int[n];
        createPrefixArray(arr, ps);

        int minSum = Integer.MAX_VALUE, index = 0;

        for(int i=0; i<n; i++) {
            if(n - i >= b) {
                int sum = 0;
                int start = i;
                int end = (b + i) -1;

                if(start == 0) {
                    sum = ps[end];
                } else {
                    sum = ps[end] - ps[start - 1];
                }

                if(sum < minSum) {
                    minSum = sum;
                    index = i;
                }

            }
        }

        return index;
    }


    public void createPrefixArray(ArrayList<Integer> arr, int[] ps) {
        for(int i=0; i<arr.size(); i++) {
            if(i == 0) {
                ps[i] = arr.get(i);
            } else {
                ps[i] = ps[i - 1] + arr.get(i);
            }
        }
    }
}
