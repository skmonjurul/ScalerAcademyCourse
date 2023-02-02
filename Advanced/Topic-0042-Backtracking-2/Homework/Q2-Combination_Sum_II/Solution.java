public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;

        for(Integer num : A) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];

        for(Integer num : A) {
            arr[num]++;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> buffer = new ArrayList<>();

        combinationSum(arr, 0, 0, B, buffer, result);

        return result;
    }

    public void combinationSum(int[] arr, int index, int sum, int target, ArrayList<Integer> buffer, ArrayList<ArrayList<Integer>> result) {
        if(sum == target) {
            result.add(new ArrayList<Integer> (buffer));
            return;
        }

        if(sum > target || index == arr.length) return;

        if(arr[index] == 0) {
            combinationSum(arr, index + 1, sum, target, buffer, result);
        }

        else {
            int element = index;
            int maxNoOfTimes = arr[index];

            for(int i = 0; i <= maxNoOfTimes; i++) {
                int k = 0;
                int total = 0;

                while(k < i) {
                    buffer.add(element);
                    total += element;
                    k++;
                }
                combinationSum(arr, index + 1, sum + total, target, buffer, result);

                k = 0;
                while(k < i) {
                    buffer.remove(buffer.size() - 1);
                    k++;
                }
            }
        }
    }
}
