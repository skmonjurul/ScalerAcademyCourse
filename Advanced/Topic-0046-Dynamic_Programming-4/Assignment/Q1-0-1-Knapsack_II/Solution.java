public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        return knapsackBottomUp(A, B, C);
    }

    public int knapsackBottomUp(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int totalValue = 0;
        for(Integer num : A) {
            totalValue += num;
        }
        int[][] maxValue = new int[A.size() + 1][totalValue + 1];

        for(int index = A.size(); index >= 0; index--) {
            for(int value = 0; value <= totalValue; value++) {
                // last row first column
                if(index == A.size() && value == 0) continue;
                // last row except first column
                if(index == A.size() && value > 0) {
                    maxValue[index][value] = Integer.MAX_VALUE;
                    continue;
                }

                int skip = maxValue[index + 1][value];
                maxValue[index][value] = skip;

                if(A.get(index) <= value && maxValue[index + 1][value - A.get(index)] != Integer.MAX_VALUE) {
                    int take = B.get(index) + maxValue[index + 1][value - A.get(index)];
                    maxValue[index][value] = Math.min(skip, take);
                }
            }
        }



        int value = totalValue;

        while(maxValue[0][value] > C) {
            value--;
        }

        return value;

    }
}
