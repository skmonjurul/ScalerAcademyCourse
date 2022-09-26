public class Solution {
    public int solve(ArrayList<Integer> arr, ArrayList<Integer> b) {
        int n = arr.size();
        int minSum = Integer.MAX_VALUE;

        for(int j = 1; j < n-1; j++) {

//            left side

            int i = j - 1;
            int minLeftSide = -1;
            while(i >= 0) {
                if(arr.get(i) < arr.get(j)) {
                    if(minLeftSide == -1) {
                        minLeftSide = i;
                    } else if(b.get(i) < b.get(minLeftSide)) {
                        minLeftSide = i;
                    }
                }
                i--;
            }

            if(minLeftSide == -1) continue;

//            right side

            int k = j + 1;
            int minRightSide = -1;

            while(k < n) {
                if(arr.get(k) > arr.get(j)) {
                    if(minRightSide == -1) {
                        minRightSide = k;
                    } else if(b.get(k) < b.get(minRightSide)) {
                        minRightSide = k;
                    }
                }

                k++;
            }

            if(minRightSide == -1) continue;

            int sum = b.get(minLeftSide) + b.get(j) + b.get(minRightSide);
            if(sum < minSum) minSum = sum;
        }

        if(minSum == Integer.MAX_VALUE) return -1;
        return minSum;
    }
}
