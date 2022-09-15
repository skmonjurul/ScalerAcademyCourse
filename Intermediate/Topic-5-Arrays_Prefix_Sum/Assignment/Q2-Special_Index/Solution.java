public class Solution {
    public int solve(ArrayList<Integer> arr) {
        int[] psOdd = new int[arr.size()];
        int[] psEven = new int[arr.size()];

        psEven[0] = arr.get(0);
        psOdd[0] = 0;

        //create the odd and even prefix sum array
        for(int i=1; i<arr.size(); i++) {
            if(i % 2 == 0) {
                psEven[i] = psEven[i - 1] + arr.get(i);
                psOdd[i] = psOdd[i - 1];
            } else {
                psOdd[i] = psOdd[i-1] + arr.get(i);
                psEven[i] = psEven[i - 1];
            }
        }

        int n = arr.size();

        int oddSum = 0, evenSum = 0, count = 0;
        for(int i=0; i<arr.size(); i++) {
            if(i == 0) {
                oddSum = psEven[n - 1];
                evenSum = psOdd[n - 1];
            } else {
                oddSum = psOdd[i -1] + (psEven[n - 1] - psEven[i]);
                evenSum = psEven[i - 1] + (psOdd[n - 1] - psOdd[i]);
            }

            if(oddSum == evenSum) count++;
        }

        return count;

    }
}
