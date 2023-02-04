public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int[] arr = new int[A.get(0).size()];
        for(int i = 0; i < A.get(0).size(); i++) {
            arr[i] = Math.max(A.get(0).get(i), A.get(1).get(i));
        }

        // using normal recursion

        /*
        return maxSumWithRecursion(arr, 0);
        */

        // using recursion with DP

        /*
        int[] cache = new int[arr.length];
        Arrays.fill(cache, -1);

        return maxSumWithRecursionWithDP(arr, 0, cache);
        */

        // using bottom up approach
        return maxSumWithBottomUp(arr);
    }

    public int maxSumWithRecursion(int[] arr, int index) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];

        if(index >= arr.length) return 0;

        int sumWithCurrentVal = arr[index] + maxSumWithRecursion(arr, index + 2);
        int sumWithoutCurrentVal = maxSumWithRecursion(arr, index + 1);

        return Math.max(sumWithCurrentVal, sumWithoutCurrentVal);
    }

    public int maxSumWithRecursionWithDP(int[] arr, int index, int[] cache) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];

        if(index >= arr.length) return 0;

        if(cache[index] == -1) {
            int sumWithCurrentVal = arr[index] + maxSumWithRecursionWithDP(arr, index + 2, cache);
            int sumWithoutCurrentVal = maxSumWithRecursionWithDP(arr, index + 1, cache);

            cache[index] = Math.max(sumWithCurrentVal, sumWithoutCurrentVal);
        }

        return cache[index];
    }

    public int maxSumWithBottomUp(int[] arr) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];

        int[] cache = new int[arr.length];
        // till first index, there is only one element
        cache[0] = arr[0];

        // till second index, choose the max
        cache[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++) {
            // take the current element, so can not take the just previous element
            // take the max element till i - 2, which we will find in the cache
            int sumWithCurrentVal = arr[i] + cache[i - 2];

            // dont take the current val, so need max element till i - 1,
            // which we will find in the cache
            int sumWithoutCurrentVal = cache[i - 1];

            cache[i] = Math.max(sumWithCurrentVal, sumWithoutCurrentVal);
        }

        int maxSum = Integer.MIN_VALUE;

        for(int num : cache) {
            maxSum = Math.max(maxSum, num);
        }

        return maxSum;
    }
}
