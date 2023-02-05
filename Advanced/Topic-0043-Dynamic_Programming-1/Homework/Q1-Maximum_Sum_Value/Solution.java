public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        int[] arr = new int[A.size()];
        for(int i = 0; i < A.size(); i++) {
            arr[i] = A.get(i);
        }

        int[] numbers = new int[3];
        numbers[0] = B;
        numbers[1] = C;
        numbers[2] = D;

        return maximumValue(arr, numbers);
    }

    public int maximumValue(int[] arr, int[] numbers) {

        int[] cache = new int[arr.length];

        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            for(int j = 0; j < arr.length; j++) {
                if(j > 0)
                    cache[j] = Math.max((num * arr[j]) + cache[j], cache[j - 1]);
                else
                    cache[j] = (num * arr[j]) + cache[j];
            }
        }

        return cache[cache.length - 1];
    }



    // using recursion
    public int maximumValue(int[] arr, int index, int[] numbers, int start) {
        if(index >= arr.length) return Integer.MIN_VALUE;
        if(start >= numbers.length) return 0;

        int max = Integer.MIN_VALUE;

        int skip = maximumValue(arr, index + 1, numbers, start);

        max = Math.max(max, skip);

        int sum = arr[index] * numbers[start];

        int oneTime = sum  +  maximumValue(arr, index + 1, numbers, start + 1);

        max = Math.max(max, oneTime);

        start++;

        sum = sum + arr[index] * numbers[start];

        int twoTime = sum +  maximumValue(arr, index + 1, numbers, start + 1);

        max = Math.max(max, twoTime);

        start++;
        sum = sum + arr[index] * numbers[start];

        int threeTime = sum +  maximumValue(arr, index + 1, numbers, start + 1);

        max = Math.max(max, threeTime);

        return max;
    }
}
